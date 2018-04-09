package javase10.t02;

import java.sql.*;

public class BookDAO extends AbstractDAO {

    public static final String SQL_CREATE_TABLE = "CREATE TABLE books(id_book int (100), title text, author text, year_of_publication int(100))";
    public static final String SQL_DROP_TABLE = "DROP TABLE books";

    public static final String SQL_INSERT_NEW_BOOK = "INSERT INTO books(id_book, title, author, year_of_publication) VALUES(?, ?,?,?)";

    public static final String SQL_DELETE_BOOK_BY_ID = "DELETE FROM books WHERE id_book = ?";
    public static final String SQL_DELETE_BOOKS_BY_TITLE = "DELETE FROM books WHERE title = ?";
    public static final String SQL_DELETE_BOOKS_BY_AUTHOR = "DELETE FROM books WHERE author = ?";
    public static final String SQL_DELETE_BOOKS_BY_YEAR_OF_PUBLICATION = "DELETE FROM books WHERE year_of_publication = ?";

    public static final String SQL_SELECT_BOOK_BY_NUMERIC_VALUE = "SELECT * FROM books WHERE id_book = ? OR year_of_publication = ?";
    public static final String SQL_SELECT_BOOK_BY_LINE_VALUE = "SELECT * FROM books WHERE title = ? OR author = ?";
    public static final String SQL_SELECT_ALL_BOOKS = "SELECT * FROM books";

    public BookDAO(Connection connection) {
        super(connection);
    }

    public void createTable() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            int countRows = statement.executeUpdate(SQL_CREATE_TABLE);
            System.out.println("Count rows: " + countRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
        }
    }

    public void deleteTable() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            int countRows = statement.executeUpdate(SQL_DROP_TABLE);
            System.out.println("Count rows: " + countRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
        }
    }

    public void addBook(int id, String title, String author, int yearOfPublication) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT_NEW_BOOK);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, title);
            preparedStatement.setString(3, author);
            preparedStatement.setInt(4, yearOfPublication);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
        }
    }

    private void deleteBooksByNumericalValue(int numericalValue, String request) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(request);
            preparedStatement.setInt(1, numericalValue);
            preparedStatement.executeUpdate();
            System.out.println("Book is deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Book is not deleted");
        } finally {
            this.closeStatement(preparedStatement);
        }
    }

    private void deleteBooksByLineValue(String line, String request) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, line);
            preparedStatement.executeUpdate();
            System.out.println("Book is deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Book is not deleted");
        } finally {
            this.closeStatement(preparedStatement);
        }
    }

    public void deleteBookById(int id) {
        deleteBooksByNumericalValue(id, SQL_DELETE_BOOK_BY_ID);
    }

    public void deleteBooksByTitle(String title) {
        deleteBooksByLineValue(title, SQL_DELETE_BOOKS_BY_TITLE);
    }

    public void deleteBooksByAuthor(String author) {
        deleteBooksByLineValue(author, SQL_DELETE_BOOKS_BY_AUTHOR);
    }

    public void deleteBooksByYear(int year_of_publication) {
        deleteBooksByNumericalValue(year_of_publication, SQL_DELETE_BOOKS_BY_YEAR_OF_PUBLICATION);
    }

    public void searchBooks(int numericalValue) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_BOOK_BY_NUMERIC_VALUE);
            preparedStatement.setInt(1, numericalValue);
            preparedStatement.setInt(2, numericalValue);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id_book") + " " +
                        resultSet.getString("title") + " " +
                        resultSet.getString("author") + " " +
                        resultSet.getInt("year_of_publication"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(resultSet);
            this.closeStatement(preparedStatement);
        }
    }

    public void searchBooks(String lineValue) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_BOOK_BY_LINE_VALUE);
            preparedStatement.setString(1, lineValue);
            preparedStatement.setString(2, lineValue);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id_book") + " " +
                        resultSet.getString("title") + " " +
                        resultSet.getString("author") + " " +
                        resultSet.getInt("year_of_publication"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResultSet(resultSet);
            this.closeStatement(preparedStatement);
        }
    }

    public void printALlBooks() {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL_BOOKS);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id_book") + " " +
                        resultSet.getString("title") + " " +
                        resultSet.getString("author") + " " +
                        resultSet.getInt("year_of_publication"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
        }
    }
}
