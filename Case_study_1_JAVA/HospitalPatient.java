class Patient {
    private int id;
    private String name;
    private int age;
    private double temperature;

    public Patient(int id, String name, int age, double temperature) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.temperature = temperature;
    }

    public String checkFever() {
        return temperature > 100.4 ? "Fever" : "Normal";
    }

    public void display() {
        System.out.println("Patient ID  : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Temperature : " + temperature + " F");
        System.out.println("Condition   : " + checkFever());
    }
}

public class HospitalPatient {
    public static void main(String[] args) {
        Patient p1 = new Patient(501, "Amit Singh", 32, 101.2);
        Patient p2 = new Patient(502, "Neha Gupta", 27, 98.6);

        p1.display();
        System.out.println();
        p2.display();
    }
}
