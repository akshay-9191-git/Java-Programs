class Samplethread extends Thread {
    private String name;
    private boolean printEven;

    Samplethread(String name, boolean printEven) {
        this.name = name;
        this.printEven = printEven;
    }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (printEven && i % 2 == 0) {
                System.out.println(name + " (Even): " + i);
            } else if (!printEven && i % 2 != 0) {
                System.out.println(name + " (Odd): " + i);
            }
        }
    }
}

public class SampleThread {
    public static void main(String[] args) {
        Samplethread jai = new Samplethread("Jai", true);   // Jai prints even
        Samplethread veeru = new Samplethread("Veeru", false); // Veeru prints odd

        jai.start();
        veeru.start();
    }
}
