import java.util.Scanner;

class Product {

    double price;
    int quantity;

    Product(double price, int quantity) throws Exception {

        if (price <= 0) {
            throw new Exception("Product price must be greater than 0.");
        }

        if (quantity <= 0) {
            throw new Exception("Quantity must be greater than 0.");
        }

        this.price = price;
        this.quantity = quantity;
    }

    double calculateBill() {

        return price * quantity;
    }
}

class Discount {

    double percentage;

    Discount(double percentage) throws Exception {

        if (percentage < 0 || percentage > 100) {
            throw new Exception("Discount must be between 0 and 100.");
        }

        this.percentage = percentage;
    }

    double calculateFinalAmount(double bill) {

        double discountAmount = bill * percentage / 100;

        return bill - discountAmount;
    }
}

class Payment {

    void pay(double amount, double bill) throws Exception {

        if (amount < bill) {
            throw new Exception("Payment amount is less than the bill.");
        }

        double change = amount - bill;

        System.out.println("Payment successful.");
        System.out.println("Change: ₹" + change);
    }
}

public class OnlineShopping {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter product price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(price, quantity);

            double bill = product.calculateBill();

            System.out.print("Enter discount percentage: ");
            double percentage = sc.nextDouble();

            Discount discount = new Discount(percentage);

            double finalAmount =
                    discount.calculateFinalAmount(bill);

            System.out.println("\n----- Bill -----");
            System.out.println("Bill: ₹" + bill);
            System.out.println("Final Amount: ₹" + finalAmount);

            System.out.print("\nEnter payment amount: ");
            double amount = sc.nextDouble();

            Payment payment = new Payment();

            payment.pay(amount, finalAmount);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}