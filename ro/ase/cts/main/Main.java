package ro.ase.cts.main;

import ro.ase.cts.classes.*;
import ro.ase.cts.interfaces.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnector();
        try (Connection connection = new DatabaseConnector().getConnection()) {
            TableCreator tableCreation = new TableCreator();
            tableCreation.createTable(connection);
            DataInserter dataInserter = new DataInserter();
            dataInserter.insertData(connection);

            DataReader dataReader = new DataReader();
            ResultSet resultSet = dataReader.readData(connection);

            DataWriter dataWriter = new DataWriter();
            dataWriter.displayData(resultSet);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

