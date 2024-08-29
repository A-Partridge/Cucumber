package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    Connection connection;
    java.sql.Statement statement;
    ResultSet resultSet;
    String columnValue;

    public String getDataFromDb(String columnName) {
        try {
            // Setting properties for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // jdbc:mysql://hostName:portNumber/databaseName
            String sqlUrl = "jdbc:mysql://44.195.13.80:3306/december_2023";
            String sqlUserName = "student";
            String sqlPassword = "Student@123";
            String sqlQuery = "SELECT * FROM login_data;";

            // Establish connection to DB
            connection = DriverManager.getConnection(sqlUrl, sqlUserName, sqlPassword);

            // Empowering connection reference variable to execute queries
            statement = connection.createStatement();

            // Execute query
            resultSet = statement.executeQuery(sqlQuery);

            // Iterate through the result set and get the column value
            if (resultSet.next()) {
                columnValue = resultSet.getString(columnName);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Close the statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return columnValue;
    }
}
