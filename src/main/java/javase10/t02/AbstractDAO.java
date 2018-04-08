package javase10.t02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void addSomeInformationToLibrary();
    public abstract void findSomeInformationInLibrary();
    public abstract void deleteSomeInformationFromLibrary();

    //Это метод закрывает только один connection, актуальный для данного abstractDAO
    public void close() {
        try{
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //todo я не знаю, нужно ли здесь закрывать statement,
    //Нужно, просто вызывается каждый раз этот метод и в него помещается statement
    protected void closeStatement(Statement statement) {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}