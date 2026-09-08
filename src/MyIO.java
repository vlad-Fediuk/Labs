import java.util.List;
import java.util.Scanner;

public final class MyIO {
    private static final Scanner SCANNER = new Scanner(System.in);

    private MyIO() {
    }

    public static int readMenuOption() {
        while (true) {
            showMenu();
            String line = SCANNER.nextLine().trim();
            if (line.matches("[1-6]")) {
                return Integer.parseInt(line);
            }
            System.out.println("Invalid input. Please enter a number between 1 and 6.");
        }
    }

    public static Student readStudent() {
        System.out.println("Enter the name of the new student:");
        String name = SCANNER.nextLine().trim();

        System.out.println("Enter the age of the new student:");
        String ageStr = SCANNER.nextLine().trim();
        int age = ageStr.matches("\\d+") ? Integer.parseInt(ageStr) : 0;

        System.out.println("Enter the group of the new student:");
        String group = SCANNER.nextLine().trim();

        System.out.println("Student added successfully.");
        return new Student(name, age, group);
    }

    public static Grade readGrade(Journal journal) {
        System.out.println("Enter the name of the student to add grades:");
        String studentName = SCANNER.nextLine().trim();
        Student student = journal.findStudentByName(studentName);
        if (student == null) {
            showStudentNotFoundMessage();
            return null;
        }

        System.out.println("Enter the subject (Java, Python, Cpp, Csharp):");
        String subjectInput = SCANNER.nextLine().trim();
        Subject subject = parseSubject(subjectInput);
        if (subject == null) {
            System.out.println("Invalid subject. Please enter Java, Python, Cpp, or Csharp.");
            return null;
        }

        System.out.println("Enter the grade value (0.0 - 10.0):");
        String gradeStr = SCANNER.nextLine().trim();
        if (!gradeStr.matches("\\d+(\\.\\d+)?")) {
            System.out.println("Invalid grade value. Please enter a number between 0.0 and 10.0.");
            return null;
        }

        double gradeValue = Double.parseDouble(gradeStr);
        if (gradeValue < 0.0 || gradeValue > 10.0) {
            System.out.println("Grade value must be between 0.0 and 10.0.");
            return null;
        }

        return new Grade(student.getName(), subject, gradeValue);
    }

    public static String readStudentNameForGrades() {
        System.out.println("Enter the name of the student to show grades:");
        return SCANNER.nextLine().trim();
    }

    public static String readStudentNameForAverage() {
        System.out.println("Enter the name of the student to show average grade:");
        return SCANNER.nextLine().trim();
    }

    public static void showStudents(List<Student> students) {
        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", Group: " + student.getGroup());
        }
    }

    public static void showGrades(String studentName, List<Grade> grades) {
        System.out.println("Grades for " + studentName + ":");
        for (Grade grade : grades) {
            System.out.printf("%s: %.2f%n", grade.getSubject(), grade.getGradeValue());
        }
    }

    public static void showAverageGrade(String studentName, double average) {
        System.out.printf("Average grade for %s: %.2f%n", studentName, average);
    }

    public static void showMenu() {
        System.out.println("===========MENU===========");
        System.out.println("Choose an option:");
        System.out.println("1 - Show all students");
        System.out.println("2 - Add a new student");
        System.out.println("3 - Add new grades to a student");
        System.out.println("4 - Show grades for a student");
        System.out.println("5 - Show average grade for a student");
        System.out.println("6 - Exit");
        System.out.println("==========================");
    }

    public static void showExitMessage() {
        System.out.println("Exiting...");
    }

    public static void showInvalidOptionMessage() {
        System.out.println("Invalid option. Please try again.");
    }

    public static void showStudentNotFoundMessage() {
        System.out.println("Student not found.");
    }

    public static void showNoGradesMessage(String studentName) {
        System.out.println("No grades found for " + studentName);
    }

    public static void showGradeAddedMessage(String studentName) {
        System.out.println("Grade added successfully for " + studentName + ".");
    }

    private static Subject parseSubject(String input) {
        for (Subject s : Subject.values()) {
            if (s.name().equalsIgnoreCase(input)) {
                return s;
            }
        }
        return null;
    }
}
