import java.util.Scanner;
interface Payment{
    void pay(double amount);
}

class CreditCardPayment implements Payment{
    @Override
    public void pay(double amount){
        System.out.println(amount + "paid using Credit Card.");
    }
}

class UPIPayment implements Payment{
    @Override
    public void pay(double amount){
        System.out.println(amount + "Paid using UPI.");
    }
}

class NetBankingPayment implements Payment{
    @Override
    public void pay(double amount){
    System.out.println(amount + "Paid using NetBanking.");
    }
}


public class PaymentSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter payment amount: ");
        double amount = sc.nextDouble();

        System.out.println("Payment Methods: ");
        System.out.println("1. Credit Cards");
        System.out.println("2. UPI");
        System.out.println("3. Net Banking");

        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        Payment payment;

        switch(choice){
            case 1: payment = new CreditCardPayment();break;
            case 2: payment = new UPIPayment(); break;
            case 3: payment = new NetBankingPayment(); break;

            default: System.out.println("Invalid payment method.");
            return;


        }
        payment.pay(amount);
        sc.close();
    }
    
}
