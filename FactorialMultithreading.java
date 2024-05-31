class FactorialCalculator extends Thread {
    private final int start;
    private final int end;
    private long result = 1;

    public FactorialCalculator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            result *= i;
        }
    }

    public long getResult() {
        return result;
    }
}

public class FactorialMultithreading {
    public static void main(String[] args) {
        int n = 5; // Change this to the desired number

        FactorialCalculator evenThread = new FactorialCalculator(2, n);
        FactorialCalculator oddThread = new FactorialCalculator(1, n);

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();

            long finalFactorial = evenThread.getResult() * oddThread.getResult();
            System.out.println("Factorial of " + n + " is: " + finalFactorial);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
