import java.util.Scanner;

class ATM {
    private int pin;
    private double balance;

    ATM(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    boolean checkPin(int enteredPin) {
        return enteredPin == pin;
    }

    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance.");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        }
        else {
            System.out.println("Invalid amount.");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ATM atm = new ATM(1234, 10000);

        boolean authenticated = false;

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (atm.checkPin(enteredPin)) {
                authenticated = true;
                System.out.println("PIN verified successfully.");
                break;
            }
            else {
                System.out.println("Incorrect PIN.");
                System.out.println(
                    "Attempts remaining: " + (3 - attempt)
                );
            }
        }

        if (!authenticated) {
            System.out.println("Maximum incorrect attempts reached.");
            System.out.println("Account blocked.");
            return;
        }

        int choice;

        do {

            System.out.println("ATM MENU ");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    atm.withdraw(withdraw);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    atm.deposit(deposit);
                    break;

                case 3:
                    atm.displayBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }
}