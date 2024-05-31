class SumCalculatorThread extends Thread {
    private final int start;
    private final int end;
    private long partialSum = 0;

    public SumCalculatorThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            partialSum += i;
        }
    }

    public long getPartialSum() {
        return partialSum;
    }
}

public class ParallelSumCalculation {
    public static void main(String[] args) {
        int numThreads = 5; 
        int segmentSize = 100 / numThreads; 

        SumCalculatorThread[] threads = new SumCalculatorThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = i * segmentSize + 1;
            int end = (i + 1) * segmentSize;
            threads[i] = new SumCalculatorThread(start, end);
            threads[i].start();
        }

        long totalSum = 0;
        for (SumCalculatorThread thread : threads) {
            try {
                thread.join(); 
                totalSum += thread.getPartialSum();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Sum of numbers from 1 to 100: " + totalSum);
    }
}
