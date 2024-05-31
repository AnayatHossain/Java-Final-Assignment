class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.err.println("Error: Cannot deposit a negative or zero amount.");
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.err.println("Error: Withdrawal amount must be positive.");
            return;
        }

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
        } else {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankTransactionImagine {
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccount(1000.0);
            account.deposit(500.0);
            account.withdraw(300.0);
            account.withdraw(800.0); // This will throw an exception
        } catch (InsufficientBalanceException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
