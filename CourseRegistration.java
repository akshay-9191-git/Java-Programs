import java.util.Scanner;

class Student {

    String name;
    String[] courses = new String[5];
    int courseCount = 0;

    Student(String name) {
        this.name = name;
    }

    void registerCourse(String course) {

        if (courseCount < 5) {

            courses[courseCount] = course;
            courseCount++;

            System.out.println(
                "Course registered successfully."
            );

        } else {

            System.out.println(
                "Cannot register more than 5 courses."
            );
        }
    }

    void displayCourses() {

        System.out.println("\n----- Student Details -----");
        System.out.println("Student Name: " + name);

        System.out.println("Registered Courses:");

        if (courseCount == 0) {
            System.out.println("No courses registered.");
        }

        for (int i = 0; i < courseCount; i++) {
            System.out.println(
                (i + 1) + ". " + courses[i]
            );
        }
    }
}

public class CourseRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        Student student = new Student(name);

        for (int i = 0; i < 6; i++) {

            System.out.print(
                "Enter course " + (i + 1) + ": "
            );

            String course = sc.nextLine();

            student.registerCourse(course);
        }

        student.displayCourses();
        sc.close();
    }
}