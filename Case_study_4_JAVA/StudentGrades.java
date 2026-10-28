import java.util.ArrayList;

class Student {
    private String name;
    private ArrayList<Integer> marks = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addMarks(int... subjectMarks) {
        for (int m : subjectMarks) {
            marks.add(m);
        }
    }

    public int getTotal() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total;
    }

    public double getPercentage() {
        return getTotal() * 100.0 / (marks.size() * 100);
    }

    public String getGrade() {
        double p = getPercentage();
        if (p >= 90) return "A";
        else if (p >= 75) return "B";
        else if (p >= 60) return "C";
        else if (p >= 50) return "D";
        else return "Fail";
    }

    public void display() {
        System.out.printf("%-8s %-28s %6d %9.2f%% %6s%n",
                name, marks.toString(), getTotal(), getPercentage(), getGrade());
    }
}

public class StudentGrades {
    public static void main(String[] args) {
        Student s1 = new Student("Akshay");
        s1.addMarks(95, 92, 90, 88, 94);
        Student s2 = new Student("Neha");
        s2.addMarks(78, 82, 75, 80, 70);
        Student s3 = new Student("Rahul");
        s3.addMarks(65, 58, 62, 70, 60);
        Student s4 = new Student("Simran");
        s4.addMarks(52, 55, 48, 50, 60);
        Student s5 = new Student("Vikas");
        s5.addMarks(40, 35, 45, 30, 42);

        System.out.printf("%-8s %-28s %6s %10s %6s%n", "Name", "Marks", "Total", "Percent", "Grade");
        System.out.println("-".repeat(64));
        s1.display();
        s2.display();
        s3.display();
        s4.display();
        s5.display();
    }
}
