import java.util.Stack;

class Student {
    private String name;
    private double percentage;

    public Student(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() { return name; }

    public double getPercentage() { return percentage; }

    public int getScholarship() {
        if (percentage >= 90) return 20000;
        else if (percentage >= 80) return 15000;
        else if (percentage >= 70) return 10000;
        else if (percentage >= 60) return 5000;
        else return 0;
    }
}

class ScholarshipOffice {
    private Stack<Student> students = new Stack<>();

    public void addStudent(Student s) {
        students.push(s);
    }

    public void processScholarships() {
        int total = 0;
        System.out.printf("%-8s %9s %14s%n", "Student", "Percent", "Scholarship");
        System.out.println("-".repeat(34));
        while (!students.isEmpty()) {
            Student s = students.pop();
            int amount = s.getScholarship();
            total += amount;
            System.out.printf("%-8s %8.1f%% %9s%d%n", s.getName(), s.getPercentage(), "Rs. ", amount);
        }
        System.out.println("-".repeat(34));
        System.out.println("Total scholarship amount: Rs. " + total);
    }
}

public class ScholarshipStack {
    public static void main(String[] args) {
        ScholarshipOffice office = new ScholarshipOffice();
        office.addStudent(new Student("Akshay", 92));
        office.addStudent(new Student("Neha", 85.5));
        office.addStudent(new Student("Rahul", 72));
        office.addStudent(new Student("Sneha", 64));
        office.addStudent(new Student("Vikas", 55));
        office.processScholarships();
    }
}
