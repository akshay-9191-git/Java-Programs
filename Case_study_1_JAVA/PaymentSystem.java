interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) { this.cardNumber = cardNumber; }

    @Override
    public void pay(double amount) {
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Paid Rs. " + amount + " using Credit Card ending with " + last4);
    }
}

class UPIPayment implements Payment {
    private String upiId;

    public UPIPayment(String upiId) { this.upiId = upiId; }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using UPI ID: " + upiId);
    }
}

class NetBankingPayment implements Payment {
    private String bankName;

    public NetBankingPayment(String bankName) { this.bankName = bankName; }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " using Net Banking (" + bankName + ")");
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        // Runtime polymorphism: one reference type, many implementations
        Payment[] payments = {
            new CreditCardPayment("1234567812345678"),
            new UPIPayment("akshay@upi"),
            new NetBankingPayment("State Bank of India")
        };

        for (Payment p : payments) {
            p.pay(2500.00);
        }
    }
}
