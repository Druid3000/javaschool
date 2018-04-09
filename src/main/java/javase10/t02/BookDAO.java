package javase10.t02;

import java.sql.*;

public class BookDAO extends AbstractDAO {

    public static final String SQL_CREATE_TABLE = "CREATE TABLE books(title text, author text, year_of_publication int(100))";
    public static final String SQL_SELECT_ALL_BOOKS = "SELECT * FROM books";
    public static final String SQL_DROP_TABLE = "DROP TABLE books";


    public static final String SQL_INSERT_NEW_BOOK = "INSERT INTO books(title, author, year_of_publication) VALUES(?,?,?)";


    public static final String SQL_UPDATE = "UPDATE students SET name = 'NewPetrov' WHERE id_group = 6";
    public static final String SQL_SELECT_FROM = "SELECT * FROM students";

    public BookDAO(Connection connection) {
        super(connection);
    }

    public void addSomeInformationToLibrary(){ }
    public void findSomeInformationInLibrary(){ }
    public void deleteSomeInformationFromLibrary(){ }

    public void createTableBooks(){
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

    public void printALlBooks() {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_ALL_BOOKS);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title") + " " +
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

    public void addBook(String title, String author, int yearOfPublication){
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT_NEW_BOOK);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, yearOfPublication);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
