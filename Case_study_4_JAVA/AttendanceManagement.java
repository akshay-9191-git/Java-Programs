import java.util.ArrayList;

class Attendance {
    private ArrayList<String> students = new ArrayList<>();

    public void addStudent(String name) {
        if (students.contains(name)) {
            System.out.println(name + " is already marked present.");
        } else {
            students.add(name);
            System.out.println("Added: " + name);
        }
    }

    public void displayStudents() {
        System.out.println("\nStudents present:");
        if (students.isEmpty()) {
            System.out.println("  (none)");
        }
        for (int i = 0; i < students.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + students.get(i));
        }
    }

    public void searchStudent(String name) {
        int index = students.indexOf(name);
        if (index >= 0) {
            System.out.println(name + " is present (position " + (index + 1) + ").");
        } else {
            System.out.println(name + " is NOT present.");
        }
    }

    public void removeStudent(String name) {
        if (students.remove(name)) {
            System.out.println("Removed: " + name);
        } else {
            System.out.println(name + " not found, cannot remove.");
        }
    }

    public void displayCount() {
        System.out.println("Number of students present: " + students.size());
    }
}

public class AttendanceManagement {
    public static void main(String[] args) {
        Attendance attendance = new Attendance();
        attendance.addStudent("Akshay");
        attendance.addStudent("Neha");
        attendance.addStudent("Rahul");
        attendance.addStudent("Neha");
        attendance.displayStudents();
        attendance.searchStudent("Rahul");
        attendance.searchStudent("Simran");
        attendance.removeStudent("Neha");
        attendance.removeStudent("Simran");
        attendance.displayStudents();
        attendance.displayCount();
    }
}
