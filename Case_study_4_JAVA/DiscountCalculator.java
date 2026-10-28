import java.util.ArrayList;

class ShoppingBill {
    private ArrayList<Double> prices = new ArrayList<>();

    public void addPrice(double price) {
        prices.add(price);
    }

    public double calculateTotal() {
        double total = 0;
        for (double p : prices) {
            total += p;
        }
        return total;
    }

    public int getDiscountPercent(double total) {
        if (total >= 10000) return 20;
        else if (total >= 5000) return 10;
        else if (total >= 2000) return 5;
        else return 0;
    }

    public void displayBill() {
        double total = calculateTotal();
        int percent = getDiscountPercent(total);
        double discount = total * percent / 100;
        System.out.println("Prices        : " + prices);
        System.out.printf("Total amount  : Rs. %.2f%n", total);
        System.out.println("Discount rate : " + percent + "%");
        System.out.printf("Discount      : Rs. %.2f%n", discount);
        System.out.printf("Final payable : Rs. %.2f%n", total - discount);
    }
}

public class DiscountCalculator {
    public static void main(String[] args) {
        ShoppingBill bill1 = new ShoppingBill();
        bill1.addPrice(1200);
        bill1.addPrice(3500);
        bill1.addPrice(2800);
        bill1.addPrice(4500);

        ShoppingBill bill2 = new ShoppingBill();
        bill2.addPrice(1500);
        bill2.addPrice(800);

        ShoppingBill bill3 = new ShoppingBill();
        bill3.addPrice(499);
        bill3.addPrice(650);

        System.out.println("----- Bill 1 -----");
        bill1.displayBill();
        System.out.println("\n----- Bill 2 -----");
        bill2.displayBill();
        System.out.println("\n----- Bill 3 -----");
        bill3.displayBill();
    }
}
