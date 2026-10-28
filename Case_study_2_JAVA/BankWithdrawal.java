import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) { super(message); }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) { super(message); }
}

class BankAccount {
    private long accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(long accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0 || Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new InvalidAmountException("Invalid withdrawal amount! Enter an amount greater than 0.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Requested "
                    + amount + ", available " + balance + ".");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Amount withdrawn: " + amount);
    }
}

class WithdrawalService {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public WithdrawalService(BankAccount account) {
        this.account = account;
    }

    public void start() {
        String again;
        do {
            try {
                System.out.print("Enter amount to withdraw: ");
                double amount = Double.parseDouble(sc.nextLine().trim()); // NumberFormatException on text
                account.withdraw(amount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numeric amount.");
            } catch (InvalidAmountException | InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Current balance: " + account.getBalance());
            }
            System.out.print("Try again? (y/n): ");
            again = sc.nextLine().trim();
        } while (again.equalsIgnoreCase("y"));
        System.out.println("Thank you for banking with us.");
    }
}

public class BankWithdrawal {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1001234567L, "Akshay Kumar", 5000);
        WithdrawalService service = new WithdrawalService(account);
        service.start();
    }
}
