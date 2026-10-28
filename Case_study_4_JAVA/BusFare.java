import java.util.Vector;

class BusReservation {
    private static final double BASE_FARE = 500;
    private Vector<Integer> ages = new Vector<>();

    public void addPassenger(int age) {
        ages.add(age);
    }

    public double calculateFare(int age) {
        if (age < 5) return 0;
        else if (age <= 12) return BASE_FARE * 0.50;
        else if (age <= 59) return BASE_FARE;
        else return BASE_FARE * 0.70;
    }

    public void displayFares() {
        double total = 0;
        System.out.printf("%-12s %5s %10s%n", "Passenger", "Age", "Fare (Rs.)");
        System.out.println("-".repeat(30));
        for (int i = 0; i < ages.size(); i++) {
            int age = ages.get(i);
            double fare = calculateFare(age);
            total += fare;
            System.out.printf("%-12s %5d %10.2f%n", "Passenger " + (i + 1), age, fare);
        }
        System.out.println("-".repeat(30));
        System.out.printf("%-18s %10.2f%n", "Total fare", total);
    }
}

public class BusFare {
    public static void main(String[] args) {
        BusReservation reservation = new BusReservation();
        reservation.addPassenger(3);
        reservation.addPassenger(8);
        reservation.addPassenger(25);
        reservation.addPassenger(45);
        reservation.addPassenger(65);
        reservation.displayFares();
    }
}
