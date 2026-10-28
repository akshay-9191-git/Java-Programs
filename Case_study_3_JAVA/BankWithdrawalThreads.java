class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // synchronized: only one thread can execute this method at a time
    public synchronized void withdraw(String customer, double amount) {
        System.out.println(customer + " is trying to withdraw Rs. " + amount);
        if (amount <= balance) {
            try {
                Thread.sleep(100); // simulate processing time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance -= amount;
            System.out.println(customer + " withdrew Rs. " + amount
                    + " | Balance left: Rs. " + balance);
        } else {
            System.out.println(customer + " - Insufficient balance for Rs. " + amount
                    + " | Balance: Rs. " + balance);
        }
    }
}

class Customer extends Thread {
    private BankAccount account;
    private double amount;

    public Customer(String name, BankAccount account, double amount) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(getName(), amount);
    }
}

class BankSimulation {
    private BankAccount account;
    private Customer c1, c2;

    public BankSimulation(BankAccount account, Customer c1, Customer c2) {
        this.account = account;
        this.c1 = c1;
        this.c2 = c2;
    }

    public void run() {
        System.out.println("Initial balance: Rs. " + account.getBalance() + "\n");
        c1.start();
        c2.start();
        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\nFinal balance: Rs. " + account.getBalance());
    }
}

public class BankWithdrawalThreads {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(10000);
        Customer c1 = new Customer("Customer-1", account, 6000);
        Customer c2 = new Customer("Customer-2", account, 7000);
        BankSimulation simulation = new BankSimulation(account, c1, c2);
        simulation.run();
    }
}
