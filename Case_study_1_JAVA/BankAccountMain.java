class BankAccount {
    private long accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(long accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal of " + amount + " not allowed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public void displayBalance() {
        System.out.println("Account No : " + accountNumber);
        System.out.println("Holder     : " + holderName);
        System.out.println("Balance    : " + balance);
    }
}

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1001234567L, "Akshay Kumar", 5000);
        acc.displayBalance();
        acc.deposit(2000);
        acc.withdraw(10000);
        acc.withdraw(1500);
        acc.displayBalance();
    }
}
