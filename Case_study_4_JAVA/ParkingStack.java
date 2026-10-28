import java.util.Stack;

class ParkingLot {
    private static final int CAPACITY = 5;
    private Stack<String> cars = new Stack<>();

    public void parkCar(String plate) {
        if (cars.size() < CAPACITY) {
            cars.push(plate);
            System.out.println("Parked: " + plate + " (" + cars.size() + "/" + CAPACITY + ")");
        } else {
            System.out.println("Parking FULL! " + plate + " rejected.");
        }
    }

    public int calculateCharge(int hours) {
        if (hours <= 2) {
            return 50;
        }
        return 50 + (hours - 2) * 20;
    }

    public void removeLastCar(int hoursParked) {
        if (cars.isEmpty()) {
            System.out.println("No cars in the parking area.");
            return;
        }
        String plate = cars.pop();
        System.out.println(plate + " left after " + hoursParked + " hour(s). Charge: Rs. "
                + calculateCharge(hoursParked));
    }

    public void displayCars() {
        System.out.println("Cars remaining (top to bottom):");
        if (cars.isEmpty()) {
            System.out.println("  (empty)");
        }
        for (int i = cars.size() - 1; i >= 0; i--) {
            System.out.println("  " + cars.get(i));
        }
    }
}

public class ParkingStack {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        lot.parkCar("UP14-AB-1001");
        lot.parkCar("UP14-CD-2002");
        lot.parkCar("DL01-EF-3003");
        lot.parkCar("UP16-GH-4004");
        lot.parkCar("HR26-IJ-5005");
        lot.parkCar("UP14-KL-6006");
        System.out.println();
        lot.displayCars();
        System.out.println();
        lot.removeLastCar(5);
        lot.removeLastCar(2);
        System.out.println();
        lot.displayCars();
    }
}
