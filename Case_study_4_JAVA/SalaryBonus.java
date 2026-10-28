import java.util.ArrayList;

class BonusCalculator {
    private ArrayList<Integer> salaries = new ArrayList<>();

    public void addSalary(int salary) {
        salaries.add(salary);
    }

    public double calculateBonus(int salary) {
        if (salary >= 80000) return salary * 0.15;
        else if (salary >= 50000) return salary * 0.10;
        else if (salary >= 30000) return salary * 0.05;
        else return 0;
    }

    public void displayReport() {
        System.out.printf("%-10s %10s %10s %14s%n", "Employee", "Salary", "Bonus", "Revised Salary");
        System.out.println("-".repeat(48));
        for (int i = 0; i < salaries.size(); i++) {
            int salary = salaries.get(i);
            double bonus = calculateBonus(salary);
            System.out.printf("%-10s %10d %10.2f %14.2f%n",
                    "Emp " + (i + 1), salary, bonus, salary + bonus);
        }
    }
}

public class SalaryBonus {
    public static void main(String[] args) {
        BonusCalculator calculator = new BonusCalculator();
        calculator.addSalary(85000);
        calculator.addSalary(52000);
        calculator.addSalary(31000);
        calculator.addSalary(24000);
        calculator.addSalary(80000);
        calculator.displayReport();
    }
}
