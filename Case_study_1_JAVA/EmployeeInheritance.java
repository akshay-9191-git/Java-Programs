class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getTotalSalary() {
        return salary;
    }

    public void display() {
        System.out.println("Name         : " + name);
        System.out.println("Salary       : " + salary);
        System.out.println("Total Salary : " + getTotalSalary());
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getTotalSalary() {
        return salary + bonus;
    }

    @Override
    public void display() {
        System.out.println("Name         : " + name);
        System.out.println("Salary       : " + salary);
        System.out.println("Bonus        : " + bonus);
        System.out.println("Total Salary : " + getTotalSalary());
    }
}

public class EmployeeInheritance {
    public static void main(String[] args) {
        Employee e = new Employee("Ravi Sharma", 40000);
        Manager m = new Manager("Priya Verma", 70000, 15000);

        System.out.println("----- Employee -----");
        e.display();

        System.out.println("\n----- Manager -----");
        m.display();
    }
}
