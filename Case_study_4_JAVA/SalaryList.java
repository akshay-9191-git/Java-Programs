import java.util.ArrayList;
import java.util.Collections;

class SalaryRecords {
    private ArrayList<Integer> salaries = new ArrayList<>();

    public void addSalary(int salary) {
        salaries.add(salary);
    }

    public void displaySalaries() {
        System.out.println("Salaries:");
        for (int i = 0; i < salaries.size(); i++) {
            System.out.println("  Employee " + (i + 1) + ": Rs. " + salaries.get(i));
        }
    }

    public int findHighest() {
        return Collections.max(salaries);
    }

    public int calculateTotal() {
        int total = 0;
        for (int s : salaries) {
            total += s;
        }
        return total;
    }

    public double calculateAverage() {
        return salaries.isEmpty() ? 0 : (double) calculateTotal() / salaries.size();
    }

    public void displaySummary() {
        System.out.println("\nHighest salary : Rs. " + findHighest());
        System.out.println("Total salary   : Rs. " + calculateTotal());
        System.out.printf("Average salary : Rs. %.2f%n", calculateAverage());
    }
}

public class SalaryList {
    public static void main(String[] args) {
        SalaryRecords records = new SalaryRecords();
        records.addSalary(35000);
        records.addSalary(52000);
        records.addSalary(28000);
        records.addSalary(61000);
        records.addSalary(45000);
        records.displaySalaries();
        records.displaySummary();
    }
}
