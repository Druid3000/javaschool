package javase02.t05;

public class Group<T> {

    private Subject subject;
    private Map<Student, T> studentsMarks = new Map<>();

    public Group(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void addStudent(Student student, T mark) {
        studentsMarks.put(student, mark);
    }

    public void removeStudent(Student student) {
        studentsMarks.remove(student);
    }

    public T getStudentsMarks(Student student) {
        return studentsMarks.get(student);
    }

    public boolean isStudentInTheGroup(Student student) {
        return studentsMarks.containsKey(student);
    }
}
