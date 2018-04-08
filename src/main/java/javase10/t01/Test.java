package javase10.t01;

public class Test {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = new DatabaseHandler(
                "org.gjt.mm.mysql.Driver",
                "jdbc:mysql://127.0.0.1/test",
                "druid",
                "12345");

        databaseHandler.connect();

        databaseHandler.executeUpdate("CREATE TABLE students(name text, id_group int(100))");

        // г) вставьте новую запись в таблицу;
        databaseHandler.executeUpdate("INSERT INTO students (name, id_group) VALUES (\"Ivanov\",7)");
        databaseHandler.executeUpdate("INSERT INTO students (name, id_group) VALUES (\"Petrov\",6)");
        databaseHandler.executeUpdate("INSERT INTO students (name, id_group) VALUES (\"Sidorov\",5)");

        // a) извлеките информацию из таблицы с помощью подготовленного запроса;
        databaseHandler.executeQueryWithPreparedStatement("SELECT * FROM students");

        // б)обновите несколько записей в таблице;
        databaseHandler.addBatchStatement("UPDATE students SET name = 'NewPetrov' WHERE id_group = 6");
        databaseHandler.addBatchStatement("UPDATE students SET name = 'NewSidorov' WHERE id_group = 5");
        databaseHandler.executeBatchStatement();


        // в) выберите конкретную запись в таблице;
        databaseHandler.executeQuery("SELECT * FROM students WHERE id_group = 6");

        // д)Удалить таблицу
        databaseHandler.executeUpdate("DROP TABLE students");

        databaseHandler.close();
    }
}
