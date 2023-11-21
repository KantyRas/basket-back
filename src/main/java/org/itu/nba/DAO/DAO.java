package org.itu.nba.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class DAO {
    public Connection connect() {
        String url = "jdbc:postgresql://localhost:5432/rojo";
        String user = "postgres";
        String password = "root";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
