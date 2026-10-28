class Employee {
    private int id;
    private String name;
    private double basicSalary;

    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public double calculateHRA() { return 0.20 * basicSalary; }

    public double calculateDA() { return 0.10 * basicSalary; }

    public double calculateGross() { return basicSalary + calculateHRA() + calculateDA(); }

    public void displaySalaryDetails() {
        System.out.println("----- Salary Details -----");
        System.out.println("Employee ID  : " + id);
        System.out.println("Name         : " + name);
        System.out.printf("Basic Salary : %.2f%n", basicSalary);
        System.out.printf("HRA (20%%)    : %.2f%n", calculateHRA());
        System.out.printf("DA (10%%)     : %.2f%n", calculateDA());
        System.out.printf("Gross Salary : %.2f%n", calculateGross());
    }
}

public class EmployeeSalary {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Ravi Sharma", 30000);
        Employee e2 = new Employee(102, "Priya Verma", 45000);

        e1.displaySalaryDetails();
        System.out.println();
        e2.displaySalaryDetails();
    }
}
