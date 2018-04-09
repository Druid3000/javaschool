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

    synchronized public void putConnection(Connection connection) {
        if(connection != null) {
            alreadyInUse.remove(connection);
            readyToUse.add(connection);
        }
    }

    //TODO нужно ли закрывать конекшны здесь или достаточно в abstractDAO?
    //В abstractDAO закрывается только один коннект, а нам нужно все закрыть.
    synchronized public void closeAllConnections() {
        try {
            for(Connection x : readyToUse){
                if (x != null) x.close();
            }

            for(Connection x : alreadyInUse){
                if (x != null) x.close();
            }
            System.out.println("Connections is closed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connections is not closed");
        }
    }

    //TODO Сервисный метод. Удалить потом его.
    public void getInfo(){
        System.out.println(readyToUse);
        System.out.println(alreadyInUse);
    }

}
