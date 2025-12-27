package Student;
import java.util.ArrayList;

public class StudentManager{
private ArrayList<Student> students = new ArrayList<>();

    // 1. add student
    public void addStudent(String name, Long id, double gpa) {
        students.add(new Student(name, id, gpa));
    }

    // 2. get student
    public ArrayList<Student> getAllStudents() {
        return students;
    }
}
