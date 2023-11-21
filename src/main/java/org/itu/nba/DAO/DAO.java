package org.itu.nba.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class DAO {
    public Connection connect() {
        String url = "jdbc:postgresql://roundhouse.proxy.rlwy.net:56186/railway";
        String user = "postgres";
        String password = "1bfg--cbCC2*f*beEgDEBc554cAe12c4";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
