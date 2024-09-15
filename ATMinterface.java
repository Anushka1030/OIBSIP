
import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + ": $" + amount;
    }
}

class Account {
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    Account() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", amount));
        return true;
    }

    public boolean transfer(Account recipient, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        this.withdraw(amount);
        recipient.deposit(amount);
        transactionHistory.add(new Transaction("Transfer to Account", amount));
        return true;
    }

    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        System.out.println("Transaction History:");
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}

public class ATMinterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Account account = new Account();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposited: $" + depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawn: $" + withdrawalAmount);
                    }
                    break;
                case 4:
                    System.out.print("Enter recipient account ID (dummy example - not implemented): ");
                    int recipientId = scanner.nextInt();
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    // In a real system, you would lookup the recipient account by ID
                    Account recipientAccount = new Account(); // Dummy recipient for this example
                    if (account.transfer(recipientAccount, transferAmount)) {
                        System.out.println("Transferred: $" + transferAmount);
                    }
                    break;
                case 5:
                    account.printTransactionHistory();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

