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
}
