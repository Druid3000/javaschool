package javase10.t01;

import java.sql.*;

public class DatabaseHandler {
    private final String DB_DRIVER;
    private final String DB_URL;
    private final String DB_USER;
    private final String DB_PASSWORD;
    private Connection connection = null;
    private Statement batchStatement = null;

    public DatabaseHandler(String DB_DRIVER, String DB_URL, String DB_USER, String DB_PASSWORD) {
        this.DB_DRIVER      = DB_DRIVER;
        this.DB_URL         = DB_URL;
        this.DB_USER        = DB_USER;
        this.DB_PASSWORD    = DB_PASSWORD;
    }

    public void connect() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            batchStatement = connection.createStatement();
            System.out.println("Connection is established");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection is not established");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection is not established");
        }
    }

    public void addBatchStatement(String request){
        try {
            batchStatement.addBatch(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeBatchStatement(){
        try {
            batchStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String request) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getInt("id_group"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void executeQueryWithPreparedStatement(String request) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(request);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getInt("id_group"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void executeUpdate(String request) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            int countRows = statement.executeUpdate(request);
            System.out.println("Count rows: " + countRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            if (connection != null) connection.close();
            if (batchStatement != null) batchStatement.close();
            System.out.println("Connection is closed");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection is not closed");
        }
    }
}
