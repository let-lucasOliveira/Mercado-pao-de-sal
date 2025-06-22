package io.mercadopaodesal.db;

/*
    @author: Lucas Oliveira
    @github: https://github.com/let-lucasOliveira
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {
    public Connection getConnection () {
        Dotenv dotenv = Dotenv.load();

        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");

        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Connection done susccessfuly");
            return conn;
        } catch (SQLException e) {
            System.out.println("Something might be wrong: " + e.getMessage());
            return null;
        }
    }   
}