class Theatre {
    private boolean[] booked; // booked[i] == true means seat i+1 is taken
    private int availableSeats;

    public Theatre(int totalSeats) {
        booked = new boolean[totalSeats];
        availableSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // synchronized: two customers can never be given the same seat
    public synchronized void bookSeats(String customer, int seatsWanted) {
        System.out.println(customer + " wants " + seatsWanted + " seat(s). Available: " + availableSeats);
        if (seatsWanted > availableSeats) {
            System.out.println(customer + " - Booking FAILED. Not enough seats.");
            return;
        }
        StringBuilder allotted = new StringBuilder();
        for (int i = 0; i < booked.length && seatsWanted > 0; i++) {
            if (!booked[i]) {
                booked[i] = true;
                allotted.append(i + 1).append(" ");
                seatsWanted--;
                availableSeats--;
            }
        }
        System.out.println(customer + " - Booking SUCCESSFUL. Seat numbers: " + allotted.toString().trim());
    }
}

class BookingCustomer extends Thread {
    private Theatre theatre;
    private int seatsWanted;

    public BookingCustomer(String name, Theatre theatre, int seatsWanted) {
        super(name);
        this.theatre = theatre;
        this.seatsWanted = seatsWanted;
    }

    @Override
    public void run() {
        theatre.bookSeats(getName(), seatsWanted);
    }
}

class BookingSimulation {
    private Theatre theatre;
    private BookingCustomer[] customers;

    public BookingSimulation(Theatre theatre, BookingCustomer... customers) {
        this.theatre = theatre;
        this.customers = customers;
    }

    public void run() {
        System.out.println("Seats available: " + theatre.getAvailableSeats() + "\n");
        for (BookingCustomer c : customers) {
            c.start();
        }
        try {
            for (BookingCustomer c : customers) {
                c.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\nSeats remaining: " + theatre.getAvailableSeats());
    }
}

public class TicketBookingThreads {
    public static void main(String[] args) {
        Theatre theatre = new Theatre(5);
        BookingCustomer c1 = new BookingCustomer("Amit", theatre, 3);
        BookingCustomer c2 = new BookingCustomer("Neha", theatre, 2);
        BookingCustomer c3 = new BookingCustomer("Rahul", theatre, 2);
        BookingSimulation simulation = new BookingSimulation(theatre, c1, c2, c3);
        simulation.run();
    }
}
