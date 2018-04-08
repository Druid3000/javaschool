package javase10.t02;

import java.sql.Connection;

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

}
