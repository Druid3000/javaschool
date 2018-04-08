package javase10.t02;

import java.sql.Connection;

public abstract class AbstractDAO {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void addSomeInformationToLibrary();
    public abstract void findSomeInformationInLibrary();
    public abstract void deleteSomeInformationFromLibrary();

}
