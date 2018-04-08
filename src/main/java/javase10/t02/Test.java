package javase10.t02;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {

        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection = connectionPool.getConnection();

        BookDAO bookDAO = new BookDAO(connection);

        bookDAO.printALlStudents();

//        //Тестирование класса ConnectionPool
//        ConnectionPool connectionPool = new ConnectionPool();
//        Connection connection = connectionPool.getConnection();
//        System.out.println(connection);
//        connectionPool.getInfo();
//        connectionPool.putConnection(connection);
//        System.out.println();
//        connectionPool.close();
//        connectionPool.getInfo();

    }
}
