import java.util.Scanner;

class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) { super(message); }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) { super(message); }
}

class InvalidDiscountException extends Exception {
    public InvalidDiscountException(String message) { super(message); }
}

class InsufficientPaymentException extends Exception {
    public InsufficientPaymentException(String message) { super(message); }
}

class Order {
    private double price;
    private int quantity;
    private double discountPercent;

    public Order(double price, int quantity, double discountPercent)
            throws InvalidPriceException, InvalidQuantityException, InvalidDiscountException {
        if (price <= 0 || Double.isNaN(price) || Double.isInfinite(price)) {
            throw new InvalidPriceException("Invalid product price! Price must be greater than 0.");
        }
        if (quantity <= 0) {
            throw new InvalidQuantityException("Invalid quantity! Quantity must be greater than 0.");
        }
        if (discountPercent < 0 || discountPercent > 100 || Double.isNaN(discountPercent)) {
            throw new InvalidDiscountException("Invalid discount! Discount must be between 0 and 100 percent.");
        }
        this.price = price;
        this.quantity = quantity;
        this.discountPercent = discountPercent;
    }

    public double calculateFinalAmount() {
        double subtotal = price * quantity;
        double discount = subtotal * discountPercent / 100;
        return subtotal - discount;
    }

    public void makePayment(double paid) throws InsufficientPaymentException {
        double bill = calculateFinalAmount();
        if (paid < bill) {
            throw new InsufficientPaymentException("Payment failed! Paid " + paid
                    + " but the bill is " + bill + ".");
        }
        System.out.println("Payment successful! Change returned: " + (paid - bill));
    }
}

class ShoppingSystem {
    private Scanner sc = new Scanner(System.in);

    private double readDouble(String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(sc.nextLine().trim()); // NumberFormatException on text
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine().trim());
    }

    public void start() {
        String again;
        do {
            try {
                double price = readDouble("Enter product price: ");
                int quantity = readInt("Enter quantity: ");
                double discount = readDouble("Enter discount percentage: ");
                Order order = new Order(price, quantity, discount);
                System.out.println("Final bill after discount: " + order.calculateFinalAmount());
                double paid = readDouble("Enter payment amount: ");
                order.makePayment(paid);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numbers only.");
            } catch (InvalidPriceException | InvalidQuantityException
                     | InvalidDiscountException | InsufficientPaymentException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Try again? (y/n): ");
            again = sc.nextLine().trim();
        } while (again.equalsIgnoreCase("y"));
        System.out.println("Thank you for shopping with us.");
    }
}

public class OnlineShopping {
    public static void main(String[] args) {
        ShoppingSystem system = new ShoppingSystem();
        system.start();
    }
}
