import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an email address: ");
            String email = scanner.nextLine();

            validateEmail(email);
            System.out.println("Valid email address: " + email);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid email format. Please enter a valid email address.");
        } catch (NullPointerException e) {
            System.err.println("Error: Email address cannot be null.");
        } finally {
            // Close any resources (e.g., scanner)
            scanner.close();
        }
    }

    private static void validateEmail(String email) {
        if (email == null) {
            throw new NullPointerException();
        }

        // Simple email format validation (for demonstration purposes)
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException();
        }
    }
}
