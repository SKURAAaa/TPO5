package org.example.tpo5_s25972;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//Klasa do zarządzania danymi samochodów w bazie danych.


public class AutomobileData {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/automobiles";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    private static final String SQL_QUERY = "SELECT * FROM automobiles WHERE category = ?";
    private static final String SQL_CATEGORIES = "SELECT DISTINCT category FROM automobiles";

//sterownik JDBC
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//POBIERAMY LISTE Z bazy
    public List<Automobile> getAutomobilesByCategory(String category) {
        List<Automobile> automobiles = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SQL_QUERY)) {
            statement.setString(1, category);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Automobile automobile = new Automobile();
                    automobile.setId(resultSet.getInt("id"));
                    automobile.setCategory(resultSet.getString("category"));
                    automobile.setBrand(resultSet.getString("brand"));
                    automobile.setProductionYear(resultSet.getInt("manufacture_year"));
                    automobile.setFuelConsumption(resultSet.getFloat("fuel_usage"));
                    automobiles.add(automobile);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return automobiles;
    }
//pobiera categgorie i zwraca w liscie
    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SQL_CATEGORIES);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                categories.add(resultSet.getString("category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
