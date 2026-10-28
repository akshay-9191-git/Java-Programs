import java.util.ArrayList;

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public void display() {
        System.out.printf("%-5d %-15s %10.2f %5d %12.2f%n",
                id, name, price, quantity, getTotalCost());
    }
}

class Cart {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotalBill() {
        double total = 0;
        for (Product p : products) {
            total += p.getTotalCost();
        }
        return total;
    }

    public void displayBill() {
        double total = getTotalBill();
        System.out.println("=".repeat(52));
        System.out.printf("%-5s %-15s %10s %5s %12s%n", "ID", "Name", "Price", "Qty", "Total");
        System.out.println("=".repeat(52));
        for (Product p : products) {
            p.display();
        }
        System.out.println("=".repeat(52));
        System.out.printf("Total Bill     : Rs. %.2f%n", total);
        if (total > 5000) {
            double discount = 0.10 * total;
            System.out.printf("Discount (10%%) : Rs. %.2f%n", discount);
            System.out.printf("Amount Payable : Rs. %.2f%n", total - discount);
        } else {
            System.out.printf("Amount Payable : Rs. %.2f%n", total);
        }
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop Bag", 1500, 2);
        Product p2 = new Product(2, "Headphones", 2200, 1);
        Product p3 = new Product(3, "Keyboard", 800, 1);

        Cart cart = new Cart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        cart.displayBill();
    }
}
