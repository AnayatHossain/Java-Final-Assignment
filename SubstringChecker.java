import java.util.Scanner;

public class SubstringChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Enter a word to check: ");
        String word = scanner.next();

        boolean isSubstring = sentence.toLowerCase().contains(word.toLowerCase());

        if (isSubstring) {
            System.out.println("The word '" + word + "' is a substring in the sentence.");
        } else {
            System.out.println("The word '" + word + "' is not a substring in the sentence.");
        }

        scanner.close();
    }
}
