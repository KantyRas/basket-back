-- classement , joueur , equipe , match equipe , match joue , point par match , rebond par match , minute par match , efficacite , FG , 3 points , lance front

-- Joueur :
--     id
--     nom
--     age

CREATE TABLE joueur(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    age INT NOT NULL
);




-- Equipe :
--     id
--     nom

CREATE TABLE equipe(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);


-- match :
--     id
--     date_heure_debut
--     date_heure_fin

CREATE TABLE match(
    id SERIAL PRIMARY KEY,
    date_heure_debut TIMESTAMP NOT NULL,
    date_heure_fin TIMESTAMP NOT NULL
);



-- composition_equipe 
--     id_match
--     id_equipe
--     id_joueur

CREATE TABLE composition_equipe(
    id_match INT NOT NULL,
    id_equipe INT NOT NULL,
    id_joueur INT NOT NULL,
    FOREIGN KEY(id_match) REFERENCES match(id),
    FOREIGN KEY(id_equipe) REFERENCES equipe(id),
    FOREIGN KEY(id_joueur) REFERENCES joueur(id)
);




CREATE TABLE tir(
    id_match INT NOT NULL,
    id_joueur INT NOT NULL,
    FOREIGN KEY(id_match) REFERENCES match(id),
    FOREIGN KEY(id_joueur) REFERENCES joueur(id)
);


CREATE TABLE deux_pt(
    id_match INT NOT NULL,
    id_joueur INT NOT NULL,
    FOREIGN KEY(id_match) REFERENCES match(id),
    FOREIGN KEY(id_joueur) REFERENCES joueur(id) 
);


CREATE TABLE trois_pt(
    id_match INT NOT NULL,
    id_joueur INT NOT NULL,
    FOREIGN KEY(id_match) REFERENCES match(id),
    FOREIGN KEY(id_joueur) REFERENCES joueur(id) 
);


-- stat_rebond_match :
--     id_match
--     id_joueur
--     minute

CREATE TABLE stat_rebond_match(
    id_match INT NOT NULL,
    id_joueur INT NOT NULL,
    FOREIGN KEY(id_match) REFERENCES match(id),
    FOREIGN KEY(id_joueur) REFERENCES joueur(id)
);
-- Ajout des statistiques de rebond pour des joueurs lors du match 1 (données de test)

-- Ajoutez d'autres statistiques de rebond pour d'autres matchs en fonction des IDs réels des joueurs et des matchs.


-- stat_passe_decisive_match :
--     id_match   
--     id_joueur

CREATE TABLE stat_passe_decisive_match(
    id_match INT NOT NULL,
    id_joueur INT NOT NULL,
    FOREIGN KEY(id_match) REFERENCES match(id),
    FOREIGN KEY(id_joueur) REFERENCES joueur(id)
);

CREATE TABLE stat_interception_match(
    id_match INT NOT NULL,
    id_joueur INT NOT NULL,
    FOREIGN KEY(id_match) REFERENCES match(id),
    FOREIGN KEY(id_joueur) REFERENCES joueur(id)
);


-- detail_entree_sortie_joueur :
--     id_match
--     id_joueur
--     minute_entree
--     minute_sortie

-- calc minute joue
CREATE TABLE detail_entree_sortie_joueur(
    id_match INT NOT NULL,
    id_joueur INT NOT NULL,
    minute_entree TIMESTAMP,
    minute_sortie TIMESTAMP,
    FOREIGN KEY(id_match) REFERENCES match(id),
    FOREIGN KEY(id_joueur) REFERENCES joueur(id)
);


CREATE OR REPLACE FUNCTION get_team_stats(team_id INT)
RETURNS TABLE(
    id_match INT,
    id_joueur INT,
    joueur VARCHAR(255),
    debut TIMESTAMP,
    fin TIMESTAMP,
    tir BIGINT,
    deux_pts BIGINT,
    trois_pts BIGINT,
    rebond BIGINT,
    passe_decisive BIGINT,
    interception BIGINT,
    minute_jouee NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT 
        composition_equipe.id_match, 
        composition_equipe.id_joueur, 
        j.nom,
        m.date_heure_debut,
        m.date_heure_fin,
        (SELECT COUNT(*) FROM tir WHERE tir.id_match = composition_equipe.id_match AND tir.id_joueur = composition_equipe.id_joueur),
        (SELECT COUNT(*) FROM deux_pt WHERE deux_pt.id_match = composition_equipe.id_match AND deux_pt.id_joueur = composition_equipe.id_joueur),
        (SELECT COUNT(*) FROM trois_pt WHERE trois_pt.id_match = composition_equipe.id_match AND trois_pt.id_joueur = composition_equipe.id_joueur),
        (SELECT COUNT(*) FROM stat_rebond_match WHERE stat_rebond_match.id_match = composition_equipe.id_match AND stat_rebond_match.id_joueur = composition_equipe.id_joueur),
        (SELECT COUNT(*) FROM stat_passe_decisive_match WHERE stat_passe_decisive_match.id_match = composition_equipe.id_match AND stat_passe_decisive_match.id_joueur = composition_equipe.id_joueur),
        (SELECT COUNT(*) FROM stat_interception_match WHERE stat_interception_match.id_match = composition_equipe.id_match AND stat_interception_match.id_joueur = composition_equipe.id_joueur),
        (SELECT SUM(ABS(EXTRACT(EPOCH FROM (detail_entree_sortie_joueur.minute_sortie - detail_entree_sortie_joueur.minute_entree))/60)) FROM detail_entree_sortie_joueur WHERE detail_entree_sortie_joueur.id_match = composition_equipe.id_match AND detail_entree_sortie_joueur.id_joueur = composition_equipe.id_joueur)
    FROM 
        composition_equipe
    JOIN joueur AS j ON j.id = composition_equipe.id_joueur
    JOIN match AS m ON m.id = composition_equipe.id_match
    WHERE 
        composition_equipe.id_equipe = team_id;
END; 
$$;