class PrintThread extends Thread {
    private final String message;
    private final int repetitions;
    private final long delayMillis;

    public PrintThread(String message, int repetitions, long delayMillis) {
        this.message = message;
        this.repetitions = repetitions;
        this.delayMillis = delayMillis;
    }

    @Override
    public void run() {
        for (int i = 0; i < repetitions; i++) {
            System.out.println(message);
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        PrintThread deptThread = new PrintThread("Dept: CSE", 10, 2000);
        PrintThread nameThread = new PrintThread("Name: Anayat Hossain", 20, 1000);
        PrintThread idThread = new PrintThread("ID: 161", 30, 800);

        nameThread.setPriority(Thread.MAX_PRIORITY);
        deptThread.setPriority(Thread.MIN_PRIORITY);

        deptThread.start();
        nameThread.start();

        try {

            nameThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        idThread.start();
    }
}
