import java.util.Scanner;

class Patient{
    int patientId;
    String name;
    int age;
    double temperature;

    Patient(int patientId , String name , int age  , double temperature){
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.temperature = temperature;
    }

    void checkTemperature(){
        if(temperature > 100.4)
            System.out.println("Condition : Fever");
        else
            System.out.println("Condition: Normal");
    }

    void display(){
        System.out.println("Patient Details");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Temperature: "+ temperature + "F");

        checkTemperature();
    }
}


public class HospitalManagement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Age: ");
        int age = sc.nextInt();

        System.out.println("Enter Temperature in Fahrenheit: ");
        double temperature = sc.nextDouble();

        Patient patient = new Patient(id , name , age , temperature);

        patient.display();
    }
    
}
