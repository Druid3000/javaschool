package javase02.t05;

public class Group {

    private Subject subject;
    private Map<Student, Number> studentsMarks = new Map<>();

    public Group(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void addStudent(Student student, Number mark) {
        studentsMarks.put(student, subject.convertMark(mark));
    }

    public void removeStudent(Student student) {
        studentsMarks.remove(student);
    }

    public Number getStudentsMarks(Student student) {
        return studentsMarks.get(student);
    }

    public boolean isStudentInTheGroup(Student student) {
        return studentsMarks.containsKey(student);
    }
}
