import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) { super(message); }
}

class Student {
    private String name;
    private int total;
    private int subjectCount;

    public Student(String name) {
        this.name = name;
    }

    public void reset() {
        total = 0;
        subjectCount = 0;
    }

    public void addMarks(int marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Invalid marks " + marks + "! Marks must be between 0 and 100.");
        }
        total += marks;
        subjectCount++;
    }

    public double calculateAverage() {
        if (subjectCount == 0) {
            throw new ArithmeticException("Cannot divide by zero! No subjects were entered.");
        }
        return (double) total / subjectCount;
    }

    public String getName() {
        return name;
    }
}

class ResultSystem {
    private Student student;
    private Scanner sc = new Scanner(System.in);

    public ResultSystem(Student student) {
        this.student = student;
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(sc.nextLine().trim()); // NumberFormatException on text
    }

    public void start() {
        String again;
        do {
            student.reset();
            try {
                int subjects = readInt("Enter number of subjects: ");
                for (int i = 1; i <= subjects; i++) {
                    student.addMarks(readInt("Enter marks of subject " + i + ": "));
                }
                double avg = student.calculateAverage();
                System.out.printf("Average marks of %s = %.2f%n", student.getName(), avg);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter whole numbers only.");
            } catch (InvalidMarksException e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Try again? (y/n): ");
            again = sc.nextLine().trim();
        } while (again.equalsIgnoreCase("y"));
        System.out.println("Result processing finished.");
    }
}

public class StudentExamResult {
    public static void main(String[] args) {
        Student student = new Student("Akshay Kumar");
        ResultSystem system = new ResultSystem(student);
        system.start();
    }
}
