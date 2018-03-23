package javase02.t05;

import javase02.t02.Array;

public class Printer {
    public static void printStudentsMarks(Array<? extends Group> listOfGroups, Student student) {

        System.out.println(student + "'s marks:");

        for (int i = 0; i < listOfGroups.size(); i++) {
            if (listOfGroups.getItem(i).isStudentInTheGroup(student)) {
                System.out.println(listOfGroups.getItem(i).getSubject() +
                        ": " +
                        listOfGroups.getItem(i).getStudentsMarks(student));
            }
        }

        System.out.println();
    }

    public static void printStudentsGroups(Array<? extends Group> listOfGroups, Student student) {

        System.out.println(student + "'s groups:");

        for (int i = 0; i < listOfGroups.size(); i++) {
            if (listOfGroups.getItem(i).isStudentInTheGroup(student)) {
                System.out.println(listOfGroups.getItem(i).getSubject());
            }
        }

        System.out.println();
    }
}