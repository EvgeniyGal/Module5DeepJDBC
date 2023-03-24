package edu.goit.databaseutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance;
    private Connection connection;


    private Database() {
    }

    public static Database getInstance() {

        if (instance == null) {
            instance = new Database();

            String dbUrl = "jdbc:h2:mem:testdb";

            try {
                instance.connection = DriverManager.getConnection(dbUrl);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return instance;

    }


    public Connection getConnection() {
        return connection;
    }
}
