import java.util.Scanner;

class Passenger {

    int age;

    Passenger(int age) {
        this.age = age;
    }

    void checkAge() throws Exception {

        if (age <= 0) {
            throw new Exception("Age must be greater than 0.");
        }
    }
}

class Bus {

    int availableSeats;

    Bus(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    void bookSeats(int seats) throws Exception {

        if (seats <= 0) {
            throw new Exception("Number of seats must be greater than 0.");
        }

        if (seats > availableSeats) {
            throw new Exception("Insufficient seats.");
        }

        availableSeats = availableSeats - seats;

        System.out.println("Booking successful.");
        System.out.println("Seats booked: " + seats);
        System.out.println("Remaining seats: " + availableSeats);
    }
}

public class BusTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter passenger age: ");
            int age = sc.nextInt();

            Passenger passenger = new Passenger(age);
            passenger.checkAge();

            System.out.print("Enter number of seats: ");
            int seats = sc.nextInt();

            Bus bus = new Bus(50);
            bus.bookSeats(seats);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}