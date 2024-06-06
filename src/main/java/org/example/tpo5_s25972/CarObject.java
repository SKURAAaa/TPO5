package org.example.tpo5_s25972;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarObject {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cars";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    private static final String SQL_QUERY = "SELECT * FROM cars WHERE type = ?";

    public List<Car> getCarsByType(String type) {
        List<Car> cars = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            statement = connection.prepareStatement(SQL_QUERY);
            statement.setString(1, type);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setType(resultSet.getString("type"));
                car.setBrand(resultSet.getString("brand"));
                car.setProdYear(resultSet.getInt("production_year"));
                car.setConsumpt(resultSet.getFloat("fuel_consumption"));
                cars.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return cars;
    }
}
