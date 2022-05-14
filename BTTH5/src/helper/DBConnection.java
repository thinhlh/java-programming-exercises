package src.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection helper class
 * This class is used to connect to the database and is a singleton class to
 * avoid multiple connections to the database
 */

public class DBConnection {

    private static String url;
    private static String username;
    private static String password;

    private static DBConnection instance = null;
    private Connection connection = null;

    private DBConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection init(String url, String username, String password) {

        DBConnection.url = url;
        DBConnection.username = username;
        DBConnection.password = password;

        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public static DBConnection getInstance() {

        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
