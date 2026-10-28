import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) { super(message); }
}

class InvalidSeatsException extends Exception {
    public InvalidSeatsException(String message) { super(message); }
}

class InsufficientSeatsException extends Exception {
    public InsufficientSeatsException(String message) { super(message); }
}

class Bus {
    private int availableSeats;

    public Bus(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookTicket(int age, int seats)
            throws InvalidAgeException, InvalidSeatsException, InsufficientSeatsException {
        if (age <= 0) {
            throw new InvalidAgeException("Invalid age! Age must be greater than 0.");
        }
        if (seats <= 0) {
            throw new InvalidSeatsException("Invalid number of seats! Seats must be greater than 0.");
        }
        if (seats > availableSeats) {
            throw new InsufficientSeatsException("Insufficient seats! Requested " + seats
                    + ", available " + availableSeats + ".");
        }
        availableSeats -= seats;
        System.out.println("Booking confirmed! Seats booked: " + seats);
    }
}

class BookingSystem {
    private Bus bus;
    private Scanner sc = new Scanner(System.in);

    public BookingSystem(Bus bus) {
        this.bus = bus;
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine().trim()); // NumberFormatException on text
    }

    public void start() {
        String again;
        do {
            try {
                int age = readInt("Enter passenger age: ");
                int seats = readInt("Enter number of seats: ");
                bus.bookTicket(age, seats);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numbers only.");
            } catch (InvalidAgeException | InvalidSeatsException | InsufficientSeatsException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Seats available now: " + bus.getAvailableSeats());
            }
            System.out.print("Try again? (y/n): ");
            again = sc.nextLine().trim();
        } while (again.equalsIgnoreCase("y"));
        System.out.println("Thank you for using the Bus Ticket Booking System.");
    }
}

public class BusTicketBooking {
    public static void main(String[] args) {
        Bus bus = new Bus(10);
        BookingSystem system = new BookingSystem(bus);
        system.start();
    }
}
