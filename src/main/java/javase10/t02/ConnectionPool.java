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

    private static PriorityQueue<Connection> readyToUse;
    private static ArrayList<Connection> alreadyInUse;

    public ConnectionPool() {

        this.DB_DRIVER = "org.gjt.mm.mysql.Driver";
        this.DB_URL = "jdbc:mysql://127.0.0.1/test";
        this.DB_USER = "druid";
        this.DB_PASSWORD = "12345";

        readyToUse = new PriorityQueue<>();
        alreadyInUse = new ArrayList<>();
    }

    synchronized public Connection getConnection() {

        if(readyToUse.size()==0)
        {
            try {
                Class.forName(DB_DRIVER);
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                alreadyInUse.add(connection);
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
        Connection connection = readyToUse.poll();
        return connection;
    }


}
