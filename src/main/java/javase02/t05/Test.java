package javase02.t05;

import javase02.t02.Array;

public class Test {
    public static void main(String[] args) {

        Student student1 = new Student("Petr", "Ivanov");
        Student student2 = new Student("Andrey", "Petrov");
        Student student3 = new Student("Victor", "Sidorov");

        Group group1 = new Group(Subject.ENGLISH);
        group1.addStudent(student1, 5);
        group1.addStudent(student2, 4.5);
        //group1.addStudent(student3, 4);

        Group group2 = new Group(Subject.MATHS);
        group2.addStudent(student1, 4);
        group2.addStudent(student2, 4.5);
        group2.addStudent(student3, 5);

        Group group3 = new Group(Subject.PHYSICS);
        group3.addStudent(student1, 5);
        group3.addStudent(student2, 4);
        //group3.removeStudent(student2);

        Array<Group> listOfGroups = new Array<>();
        listOfGroups.addItem(group1);
        listOfGroups.addItem(group2);
        listOfGroups.addItem(group3);

        Printer.printStudentsMarks(listOfGroups, student1);
        Printer.printStudentsMarks(listOfGroups, student2);
        Printer.printStudentsMarks(listOfGroups, student3);

        Printer.printStudentsGroups(listOfGroups, student2);
    }
}
