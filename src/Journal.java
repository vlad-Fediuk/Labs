import java.util.ArrayList;
import java.util.List;

public class Journal {
    private final List<Student> students;
    private final List<Grade> grades;

    public Journal(List<Student> students) {
        this.students = new ArrayList<>(students);
        this.grades = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return List.copyOf(students);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public Student findStudentByName(String name) {
        return students.stream()
                .filter(student -> student.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Grade> getGradesForStudent(String studentName) {
        return Grade.filterByName(grades, studentName);
    }

    public double getAverageGradeForStudent(String studentName) {
        return getGradesForStudent(studentName).stream()
                .mapToDouble(Grade::getGradeValue)
                .average()
                .orElse(0.0);
    }
}
