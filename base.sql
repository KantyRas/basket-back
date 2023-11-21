-- gestion de flotte de vehicule --

-- Création de la table des véhicules
CREATE TABLE vehicule (
    idvehicule SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    immatriculation VARCHAR(20) UNIQUE NOT NULL,
    annee_fabrication INT,
    modele VARCHAR(50),
    couleur VARCHAR(30)
);

-- Création de la table des kilomètres parcourus
CREATE TABLE kilometres (
    idkilometrage SERIAL PRIMARY KEY,
    idvehicule INT REFERENCES vehicule (idvehicule),
    date DATE NOT NULL,
    debut_km INT NOT NULL,
    fin_km INT NOT NULL,
    CONSTRAINT check_km_range CHECK (debut_km <= fin_km)
);

-- Création de la table des assurances
CREATE TABLE assurances (
    idassurance SERIAL PRIMARY KEY,
    idvehicule INT REFERENCES vehicule (idvehicule),
    date_assurance DATE NOT NULL,
    montant double precision NOT NULL
);

-- Création de la table des entretiens
CREATE TABLE entretiens (
    identretien SERIAL PRIMARY KEY,
    idvehicule INT REFERENCES vehicule (idvehicule),
    date_entretien DATE NOT NULL,
    type_entretien VARCHAR(50),
    montant double precision NOT NULL
);
