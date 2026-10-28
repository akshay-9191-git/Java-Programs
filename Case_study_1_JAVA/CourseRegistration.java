import java.util.ArrayList;

class Student {
    private static final int MAX_COURSES = 5;
    private String name;
    private ArrayList<String> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void registerCourse(String course) {
        if (courses.size() >= MAX_COURSES) {
            System.out.println("Cannot register '" + course + "'. Maximum of "
                    + MAX_COURSES + " courses allowed.");
        } else if (courses.contains(course)) {
            System.out.println("Already registered for " + course + ".");
        } else {
            courses.add(course);
            System.out.println("Registered for " + course + ".");
        }
    }

    public void displayCourses() {
        System.out.println("\nCourses registered by " + name + ":");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + courses.get(i));
        }
    }
}

public class CourseRegistration {
    public static void main(String[] args) {
        Student s = new Student("Akshay Kumar");
        s.registerCourse("Java");
        s.registerCourse("DBMS");
        s.registerCourse("Python");
        s.registerCourse("DSA");
        s.registerCourse("Operating Systems");
        s.registerCourse("Computer Networks");   // 6th course - rejected
        s.displayCourses();
    }
}
