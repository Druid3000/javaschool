package javase10.t02;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {

        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection = connectionPool.getConnection();

        BookDAO bookDAO = new BookDAO(connection);

        bookDAO.createTable();
        bookDAO.addBook(1, "The Master and Margarita", "Mikhail Bulgakov", 1966);
        bookDAO.addBook(2, "Crime and Punishment", "Fyodor Dostoevsky", 1866);
        bookDAO.addBook(3, "The Cherry Orchard", "Anton Chekhov", 1903);
        bookDAO.addBook(4, "The Tale of the Fisherman and the Fish", " Alexander Pushkin", 1835);

        bookDAO.printALlBooks();
        //bookDAO.deleteBooksByTitle("The Master and Margarita");
        //bookDAO.deleteBookById(1);
        //bookDAO.deleteBooksByAuthor("Mikhail Bulgakov");
        //bookDAO.deleteBooksByYear(1966);
        //bookDAO.printALlBooks();

        System.out.println("Search results:");
        bookDAO.searchBooks(1866);
        bookDAO.searchBooks("The Cherry Orchard");

        bookDAO.deleteTable();

        connectionPool.putConnection(connection);
        connectionPool.closeAllConnections();
    }
}
