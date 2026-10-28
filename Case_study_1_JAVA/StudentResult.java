import java.util.Scanner;

class Student {
    private String name;
    private int[] marks = new int[5];
    private int total;
    private double percentage;
    private String grade;

    public void acceptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        name = sc.nextLine();
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks of subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
        }
    }

    public void calculateResult() {
        total = 0;
        for (int m : marks) {
            total += m;
        }
        percentage = total / 5.0;
        grade = findGrade();
    }

    private String findGrade() {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    public boolean isPassed() {
        return percentage >= 50;
    }

    public void displayResult() {
        System.out.println("\n----- Result -----");
        System.out.println("Name       : " + name);
        System.out.println("Total      : " + total + " / 500");
        System.out.printf("Percentage : %.2f%%%n", percentage);
        System.out.println("Grade      : " + grade);
        System.out.println("Status     : " + (isPassed() ? "PASSED" : "FAILED"));
    }
}

public class StudentResult {
    public static void main(String[] args) {
        Student s = new Student();
        s.acceptDetails();
        s.calculateResult();
        s.displayResult();
    }
}
