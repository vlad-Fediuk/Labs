import java.util.List;

public final class MyIO {

    private MyIO() {
    }

    public static int readMenuOption() {
        while (true) {
            showMenu();
            String line = IO.readln().trim();
            if (line.matches("[1-6]")) {
                return Integer.parseInt(line);
            }
            IO.println("Invalid input. Please enter a number between 1 and 6.");
        }
    }

    public static Student readStudent() {
        IO.println("Enter the name of the new student:");
        String name = IO.readln().trim();

        IO.println("Enter the age of the new student:");
        String ageStr = IO.readln().trim();
        int age = ageStr.matches("\\d+") ? Integer.parseInt(ageStr) : 0;

        IO.println("Enter the group of the new student:");
        String group = IO.readln().trim();

        IO.println("Student added successfully.");
        return new Student(name, age, group);
    }

    public static Grade readGrade(Journal journal) {
        IO.println("Enter the name of the student to add grades:");
        String studentName = IO.readln().trim();
        Student student = journal.findStudentByName(studentName);
        if (student == null) {
            showStudentNotFoundMessage();
            return null;
        }

        IO.println("Enter the subject (Java, Python, Cpp, Csharp):");
        String subjectInput = IO.readln().trim();
        Subject subject = parseSubject(subjectInput);
        if (subject == null) {
            IO.println("Invalid subject. Please enter Java, Python, Cpp, or Csharp.");
            return null;
        }

        IO.println("Enter the grade value (0.0 - 10.0):");
        String gradeStr = IO.readln().trim();
        if (!gradeStr.matches("\\d+(\\.\\d+)?")) {
            IO.println("Invalid grade value. Please enter a number between 0.0 and 10.0.");
            return null;
        }

        double gradeValue = Double.parseDouble(gradeStr);
        if (gradeValue < 0.0 || gradeValue > 10.0) {
            IO.println("Grade value must be between 0.0 and 10.0.");
            return null;
        }

        return new Grade(student.getName(), subject, gradeValue);
    }

    public static String readStudentNameForGrades() {
        IO.println("Enter the name of the student to show grades:");
        return IO.readln().trim();
    }

    public static String readStudentNameForAverage() {
        IO.println("Enter the name of the student to show average grade:");
        return IO.readln().trim();
    }

    public static void showStudents(List<Student> students) {
        IO.println("List of students:");
        for (Student student : students) {
            IO.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", Group: " + student.getGroup());
        }
    }

    public static void showGrades(String studentName, List<Grade> grades) {
        IO.println("Grades for " + studentName + ":");
        for (Grade grade : grades) {
            IO.println(grade.getSubject() + ": " + grade.getGradeValue());
        }
    }

    public static void showAverageGrade(String studentName, double average) {
        IO.println("Average grade for " + studentName + ": " + average);
    }

    public static void showMenu() {
        IO.println("===========MENU===========");
        IO.println("Choose an option:");
        IO.println("1 - Show all students");
        IO.println("2 - Add a new student");
        IO.println("3 - Add new grades to a student");
        IO.println("4 - Show grades for a student");
        IO.println("5 - Show average grade for a student");
        IO.println("6 - Exit");
        IO.println("==========================");
    }

    public static void showExitMessage() {
        IO.println("Exiting...");
    }

    public static void showInvalidOptionMessage() {
        IO.println("Invalid option. Please try again.");
    }

    public static void showStudentNotFoundMessage() {
        IO.println("Student not found.");
    }

    public static void showNoGradesMessage(String studentName) {
        IO.println("No grades found for " + studentName);
    }

    public static void showGradeAddedMessage(String studentName) {
        IO.println("Grade added successfully for " + studentName + ".");
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