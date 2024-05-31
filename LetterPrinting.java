class UppercaseThread extends Thread {
    @Override
    public void run() {
        System.out.print("Uppercase Thread: ");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}

class LowercaseThread extends Thread {
    @Override
    public void run() {
        System.out.print("Lowercase Thread: ");
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + " ");
        }
    }
}

public class LetterPrinting {
    public static void main(String[] args) {
        
        UppercaseThread uppercaseThread = new UppercaseThread();
        LowercaseThread lowercaseThread = new LowercaseThread();

        uppercaseThread.start();
        try {
            uppercaseThread.join(); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        lowercaseThread.start();
    }
}
