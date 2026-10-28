import java.util.Vector;

class ElectricityBoard {
    private Vector<Integer> consumption = new Vector<>();

    public void addConsumption(int units) {
        consumption.add(units);
    }

    public double calculateBill(int units) {
        if (units <= 100) {
            return units * 2;
        } else if (units <= 200) {
            return 200 + (units - 100) * 3;
        } else {
            return 200 + 300 + (units - 200) * 5;
        }
    }

    public void displayBills() {
        System.out.printf("%-10s %6s %10s %10s %10s%n", "Customer", "Units", "Bill", "Surcharge", "Total");
        System.out.println("-".repeat(52));
        for (int i = 0; i < consumption.size(); i++) {
            int units = consumption.get(i);
            double bill = calculateBill(units);
            double surcharge = bill > 1000 ? bill * 0.10 : 0;
            System.out.printf("%-10s %6d %10.2f %10.2f %10.2f%n",
                    "Cust " + (i + 1), units, bill, surcharge, bill + surcharge);
        }
    }
}

public class ElectricityBill {
    public static void main(String[] args) {
        ElectricityBoard board = new ElectricityBoard();
        board.addConsumption(80);
        board.addConsumption(150);
        board.addConsumption(250);
        board.addConsumption(400);
        board.displayBills();
    }
}
