package javase02.t05;

import java.util.HashMap;

public class Group <T>{

    private Subject subject;
    private HashMap<String, T> studentsAssessments = new HashMap<String, T>();

    public Group(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void addStudent(String name, T assessment){
        studentsAssessments.put(name, assessment);
    }

    public void removeStudent(String name){
        studentsAssessments.remove(name);
    }

    public T getAssessmentOfStudent(String name){
        return studentsAssessments.get(name);
    }

    public boolean isStudentInTheGroup(String name){
        return studentsAssessments.containsKey(name);
    }
}
