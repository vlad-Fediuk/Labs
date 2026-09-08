import java.util.ArrayList;
import java.util.List;

 void main() {
    Journal journal = new Journal(getInitialStudents());

    while (true) {
        int action = MyIO.readMenuOption();
        if (action == 6) {
            MyIO.showExitMessage();
            return;
        }

        handleMenuOption(action, journal);
    }
}

private static List<Student> getInitialStudents() {
    return new ArrayList<>(List.of(
            new Student("Vlad", 18, "A"),
            new Student("Ion", 18, "B"),
            new Student("Nedzyk", 18, "C"),
            new Student("EuGAYnij", 18, "D")
    ));
}

private static void handleMenuOption(int option, Journal journal) {
    switch (option) {
        case 1 -> MyIO.showStudents(journal.getStudents());
        case 2 -> journal.addStudent(MyIO.readStudent());
        case 3 -> addGrade(journal);
        case 4 -> showGrades(journal);
        case 5 -> showAverageGrade(journal);
        default -> MyIO.showInvalidOptionMessage();
    }
}

private static void addGrade(Journal journal) {
    Grade grade = MyIO.readGrade(journal);
    if (grade != null) {
        journal.addGrade(grade);
        MyIO.showGradeAddedMessage(grade.getStudentName());
    }
}

private static void showGrades(Journal journal) {
    String studentName = MyIO.readStudentNameForGrades();
    Student student = journal.findStudentByName(studentName);
    if (student == null) {
        MyIO.showStudentNotFoundMessage();
        return;
    }

    MyIO.showGrades(student.getName(), journal.getGradesForStudent(student.getName()));
}

private static void showAverageGrade(Journal journal) {
    String studentName = MyIO.readStudentNameForAverage();
    Student student = journal.findStudentByName(studentName);
    if (student == null) {
        MyIO.showStudentNotFoundMessage();
        return;
    }

    List<Grade> grades = journal.getGradesForStudent(student.getName());
    if (grades.isEmpty()) {
        MyIO.showNoGradesMessage(student.getName());
        return;
    }

    MyIO.showAverageGrade(student.getName(), journal.getAverageGradeForStudent(student.getName()));
}
