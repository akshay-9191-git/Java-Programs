import java.util.Scanner;

class Employee {

    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Salary: ₹" + salary);
    }
}

class Manager extends Employee {

    double bonus;

    Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    void displayManager() {
        display();
        System.out.println("Bonus: ₹" + bonus);
        System.out.println("Total Salary: ₹" + (salary + bonus));
    }
}

public class EmployeeInheritance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary1 = sc.nextDouble();
        sc.nextLine();

        Employee employee = new Employee(name1, salary1);

        System.out.println("Employee ");
        employee.display();


        System.out.print("Enter Manager Name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter Manager Salary: ");
        double salary2 = sc.nextDouble();

        System.out.print("Enter Manager Bonus: ");
        double bonus = sc.nextDouble();

        Manager manager = new Manager(name2, salary2, bonus);

        System.out.println("Manager ");
        manager.displayManager();

        sc.close();
    }
}