import java.util.Stack;

class ATM {
    private double balance;
    private Stack<Double> transactions = new Stack<>();

    public ATM(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.push(amount);
            System.out.println("Withdrawn Rs. " + amount + " | Balance: Rs. " + balance);
        } else {
            System.out.println("Withdrawal of Rs. " + amount + " DENIED - insufficient balance (Rs. "
                    + balance + ")");
        }
    }

    public void showLastTransaction() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Latest successful transaction (peek): Rs. " + transactions.peek());
        }
    }

    public void showAllTransactions() {
        System.out.println("Transaction history (oldest to latest): " + transactions);
    }
}

public class ATMStack {
    public static void main(String[] args) {
        ATM atm = new ATM(20000);
        atm.withdraw(5000);
        atm.withdraw(3000);
        atm.withdraw(8000);
        atm.withdraw(6000);
        System.out.println();
        atm.showLastTransaction();
        atm.showAllTransactions();
    }
}
