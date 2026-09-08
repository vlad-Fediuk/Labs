import java.util.ArrayList;
import java.util.List;

public class Grade {

    private String studentName;
    private Subject subject;
    private Double gradeValue;

    Grade(String studentName, Subject subject, Double gradeValue) {
        this.studentName = studentName;
        this.subject = subject;
        this.gradeValue = gradeValue;
    }

    public String getStudentName() {
        return studentName;
    }

    public Double getGradeValue() {
        return gradeValue;
    }

    public Subject getSubject() {
        return subject;
    }

    public static List<Grade> filterBySubjectClassic(List<Grade> grades, Subject targetSubject) {
        List<Grade> filtered = new ArrayList<>();
        for (Grade grade : grades) {
            if (grade.getSubject() == targetSubject) {
                filtered.add(grade);
            }
        }
        return filtered;
    }

    public static List<Grade> filterByName(List<Grade> grades, String targetName) {
        return grades.stream()
                .filter(grade -> grade.getStudentName().equals(targetName))
                .toList();
    }
}

enum Subject {
    Java, Python, Cpp, Csharp
}