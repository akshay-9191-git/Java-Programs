import java.util.Scanner;

class Student {
    String name;
    int[] marks = new int[5];

    void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        name = sc.nextLine();

        System.out.println("Enter marks for 5 subjects:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    int calculateTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    double calculatePercentage() {
        return calculateTotal() / 5.0;
    }

    char  calculateGrade() {
        double percentage = calculatePercentage();

        if (percentage >= 90)
            return 'A';
        else if (percentage >= 80)
            return 'A';
        else if (percentage >= 70)
            return 'B';
        else if (percentage >= 60)
            return 'C';
        else if (percentage >= 50)
            return 'D';
        else
            return 'F';
    }

    void display() {
        int total = calculateTotal();
        double percentage = calculatePercentage();

        System.out.println("\n Student Result");
        System.out.println("Name: " + name);
        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage + "%");

        System.out.println("Grade: " + calculateGrade());

        if (percentage >= 50)
            System.out.println("Result: Pass");
        else
            System.out.println("Result: Fail");
    }
}

public class StudentResult {
    public static void main(String[] args) {

        Student student = new Student();

        student.input();
        student.display();
    }
}