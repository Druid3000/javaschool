package javase02.t05;

import java.util.ArrayList;

public class Printer {
    public static void printStudentsMarks(ArrayList<? extends Group> listOfGroups, Student student) {

        System.out.println(student.getName() +
                " " +
                student.getSurname() +
                "'s marks:");

        for (int i = 0; i < listOfGroups.size(); i++) {
            if (listOfGroups.get(i).isStudentInTheGroup(student)) {
                System.out.println(listOfGroups.get(i).getSubject() +
                        ": " +
                        listOfGroups.get(i).getStudentsMarks(student));
            }
        }

        System.out.println();
    }

    public static void printStudentsGroups(ArrayList<? extends Group> listOfGroups, Student student) {

        System.out.println(student.getName() +
                " " +
                student.getSurname() +
                "'s groups:");

        for (int i = 0; i < listOfGroups.size(); i++) {
            if (listOfGroups.get(i).isStudentInTheGroup(student)) {
                System.out.println(listOfGroups.get(i).getSubject());
            }
        }

        System.out.println();
    }
}