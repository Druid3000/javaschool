package javase10.t02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectionPool {
    private final String DB_DRIVER;
    private final String DB_URL;
    private final String DB_USER;
    private final String DB_PASSWORD;

    private static PriorityQueue<Connection> readyToUseConnections;
    private static ArrayList<Connection> alreadyInUseConnections;

    public ConnectionPool() {
        DataBaseManager dataBaseManager = new DataBaseManager();
        DB_DRIVER = dataBaseManager.getValue(DataBaseManager.DB_DRIVER);
        DB_URL = dataBaseManager.getValue(DataBaseManager.DB_URL);
        DB_USER = dataBaseManager.getValue(DataBaseManager.DB_USER);
        DB_PASSWORD = dataBaseManager.getValue(DataBaseManager.DB_PASSWORD);

        readyToUseConnections = new PriorityQueue<>();
        alreadyInUseConnections = new ArrayList<>();
    }

    synchronized public Connection getConnection() {

        if (readyToUseConnections.size() == 0) {
            try {
                Class.forName(DB_DRIVER);
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                alreadyInUseConnections.add(connection);
                System.out.println("Connection is established");
                return connection;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Connection is not established");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection is not established");
            }
        }
        return readyToUseConnections.poll();
    }

    synchronized public void putConnection(Connection connection) {
        if (connection != null) {
            alreadyInUseConnections.remove(connection);
            readyToUseConnections.add(connection);
        }
    }

    synchronized public void closeAllConnections() {
        try {
            for (Connection x : readyToUseConnections) {
                if (x != null) x.close();
            }
            for (Connection x : alreadyInUseConnections) {
                if (x != null) x.close();
            }
            System.out.println("Connections is closed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connections is not closed");
        }
    }
}
