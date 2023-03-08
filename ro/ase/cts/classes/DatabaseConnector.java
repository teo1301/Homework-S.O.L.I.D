package ro.ase.cts.classes;

import ro.ase.cts.interfaces.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector implements DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:database.db";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
