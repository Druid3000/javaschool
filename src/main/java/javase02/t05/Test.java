package javase02.t05;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Student student1 = new Student("Petr", "Ivanov");
        Student student2 = new Student("Andrey", "Petrov");
        Student student3 = new Student("Victor", "Sidorov");

        Group<Integer> group1 = new Group<>(Subject.ENGLISH);
        group1.addStudent(student1, 5);
        group1.addStudent(student2, 4);
        group1.addStudent(student3, 4);

        Group<Double> group2 = new Group<>(Subject.MATHS);
        group2.addStudent(student1, 4.1);
        group2.addStudent(student2, 4.5);
        group2.addStudent(student3, 5.0);

        Group<Integer> group3 = new Group<>(Subject.PHYSICS);
        group3.addStudent(student1, 5);
        group3.addStudent(student2, 4);

        ArrayList<Group> listOfGroups = new ArrayList<>();
        listOfGroups.add(group1);
        listOfGroups.add(group2);
        listOfGroups.add(group3);

        Printer.printStudentsMarks(listOfGroups, student1);
        Printer.printStudentsMarks(listOfGroups, student2);
        Printer.printStudentsMarks(listOfGroups, student3);

        Printer.printStudentsGroups(listOfGroups, student1);
    }
}
