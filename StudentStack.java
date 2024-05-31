import java.util.Scanner;
import java.util.Stack;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class StudentStack {
    public static void main(String[] args) {
        Stack<Student> studentStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        // Insert 10 Student objects
        for (int i = 1; i <= 10; i++) {
            studentStack.push(new Student("Student " + i));
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Top Student");
            System.out.println("3. Display Top Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    studentStack.push(new Student(studentName));
                    break;
                case 2:
                    if (!studentStack.isEmpty()) {
                        Student removedStudent = studentStack.pop();
                        System.out.println("Removed student: " + removedStudent.getName());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 3:
                    if (!studentStack.isEmpty()) {
                        System.out.println("Top student: " + studentStack.peek().getName());
                    } else {
                        System.out.println("Stack is empty.");
                    }
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
