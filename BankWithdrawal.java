import java.util.Scanner;

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Withdrawal amount must be greater than 0.");
        }

        if (amount > balance) {
            throw new Exception("Insufficient balance.");
        }

        balance = balance - amount;

        System.out.println("Withdrawal successful.");
        System.out.println("Remaining balance: ₹" + balance);
    }
}

public class BankWithdrawal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account balance: ");
            double balance = sc.nextDouble();

            BankAccount account = new BankAccount(balance);

            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}