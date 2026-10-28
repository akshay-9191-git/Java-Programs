import java.util.Scanner;

class ATM {
    private static final int MAX_ATTEMPTS = 3;
    private int pin;
    private double balance;
    private Scanner sc = new Scanner(System.in);

    public ATM(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    private boolean checkPin() {
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Enter PIN: ");
            if (sc.nextInt() == pin) {
                System.out.println("PIN verified. Welcome!");
                return true;
            }
            System.out.println("Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - attempt));
        }
        System.out.println("Card blocked! Too many incorrect attempts.");
        return false;
    }

    public void withdraw(double amount) {
        if (amount <= 0) System.out.println("Invalid amount.");
        else if (amount > balance) System.out.println("Insufficient balance.");
        else {
            balance -= amount;
            System.out.println("Please collect your cash: " + amount);
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void displayBalance() {
        System.out.println("Available balance: " + balance);
    }

    public void start() {
        if (!checkPin()) {
            return;
        }
        int choice;
        do {
            System.out.println("\n1. Withdraw  2. Deposit  3. Check Balance  4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    withdraw(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    deposit(sc.nextDouble());
                    break;
                case 3:
                    displayBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        ATM atm = new ATM(1234, 10000);
        atm.start();
    }
}
