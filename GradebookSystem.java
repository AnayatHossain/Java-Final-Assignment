import java.util.Scanner;

public class GradebookSystem {
    private static final int MAX_STUDENTS = 100;
    private String[] studentIDs = new String[MAX_STUDENTS];
    private double[] grades = new double[MAX_STUDENTS];
    private int numStudents = 0;

    public void addStudent(String studentID, double grade) {
        if (numStudents < MAX_STUDENTS) {
            studentIDs[numStudents] = studentID;
            grades[numStudents] = grade;
            numStudents++;
            System.out.println("Student added: " + studentID);
        } else {
            System.out.println("Gradebook is full. Cannot add more students.");
        }
    }

    public void removeStudent(String studentID) {
        for (int i = 0; i < numStudents; i++) {
            if (studentIDs[i].equals(studentID)) {
                // Shift remaining elements to fill the gap
                for (int j = i; j < numStudents - 1; j++) {
                    studentIDs[j] = studentIDs[j + 1];
                    grades[j] = grades[j + 1];
                }
                numStudents--;
                System.out.println("Student removed: " + studentID);
                return;
            }
        }
        System.out.println("Student not found: " + studentID);
    }

    public void displayStudents() {
        System.out.println("Student IDs and Grades:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(studentIDs[i] + ": " + grades[i]);
        }
    }

    public static void main(String[] args) {
        GradebookSystem gradebook = new GradebookSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.next();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    gradebook.addStudent(studentID, grade);
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    String idToRemove = scanner.next();
                    gradebook.removeStudent(idToRemove);
                    break;
                case 3:
                    gradebook.displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
