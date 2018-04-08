package javase10.t01;

import java.sql.*;

public class DatabaseHandler {
    private final String DB_DRIVER;
    private final String DB_URL;
    private final String DB_USER;
    private final String DB_PASSWORD;
    private Connection connection = null;
    private Statement batchStatement = null;
}
