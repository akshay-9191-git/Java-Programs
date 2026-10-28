class FoodPreparation extends Thread {
    private String order;

    public FoodPreparation(String order) {
        this.order = order;
    }

    @Override
    public void run() {
        System.out.println("[Kitchen] Started preparing " + order + "...");
        String[] steps = {"Chopping ingredients", "Cooking", "Packing the order"};
        for (String step : steps) {
            System.out.println("[Kitchen] " + step);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("[Kitchen] " + order + " is READY.");
    }
}

class FoodDelivery extends Thread {
    private String order;
    private String address;

    public FoodDelivery(String order, String address) {
        this.order = order;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println("[Delivery] Picked up " + order + ". Heading to " + address + "...");
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[Delivery] " + order + " delivered to " + address + ".");
    }
}

class OrderProcessor {
    private FoodPreparation preparation;
    private FoodDelivery delivery;

    public OrderProcessor(FoodPreparation preparation, FoodDelivery delivery) {
        this.preparation = preparation;
        this.delivery = delivery;
    }

    public void process() {
        try {
            preparation.start();
            preparation.join(); // wait until food preparation is completed
            delivery.start();   // delivery starts only after join() returns
            delivery.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Order completed successfully.");
    }
}

public class FoodDeliveryThreads {
    public static void main(String[] args) {
        FoodPreparation preparation = new FoodPreparation("Paneer Butter Masala");
        FoodDelivery delivery = new FoodDelivery("Paneer Butter Masala", "Sector 62, Noida");
        OrderProcessor processor = new OrderProcessor(preparation, delivery);
        processor.process();
    }
}
