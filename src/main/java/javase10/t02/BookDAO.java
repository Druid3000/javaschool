package javase10.t02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAO extends AbstractDAO {

    public static final String SQL_CREATE_TABLE = "CREATE TABLE students(name text, id_group int(100))";
    public static final String SQL_INSERT_INTO1 = "INSERT INTO students (name, id_group) VALUES (\"Ivanov\",7)";
    public static final String SQL_INSERT_INTO2 = "INSERT INTO students (name, id_group) VALUES (\"Petrov\",6)";
    public static final String SQL_INSERT_INTO3 = "INSERT INTO students (name, id_group) VALUES (\"Sidorov\",5)";
    public static final String SQL_UPDATE = "UPDATE students SET name = 'NewPetrov' WHERE id_group = 6";
    public static final String SQL_SELECT_FROM = "SELECT * FROM students";

    public BookDAO(Connection connection) {
        super(connection);
    }

    public void addSomeInformationToLibrary(){

    }

    public void findSomeInformationInLibrary(){

    }
    public void deleteSomeInformationFromLibrary(){

    }

    public void printALlStudents() {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_SELECT_FROM);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getInt("id_group"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
        }
    }

}
