import java.util.*;

public class AttendanceSystem {

    public static void markAttendance(Set<Integer> attendance,
                                      int studentId) {
        attendance.add(studentId);
    }

    public static boolean isPresent(Set<Integer> attendance,
                                    int studentId) {
        return attendance.contains(studentId);
    }

    public static int getAttendanceCount(Set<Integer> attendance) {
        return attendance.size();
    }

    public static void displayAttendance(Set<Integer> attendance) {
        StringBuilder sb = new StringBuilder();
        for (int id : attendance) {
            sb.append(id).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Set<Integer> attendance = new LinkedHashSet<>();
        markAttendance(attendance, 105);
        markAttendance(attendance, 102);
        markAttendance(attendance, 108);
        markAttendance(attendance, 105);
        markAttendance(attendance, 101);
        displayAttendance(attendance);
        System.out.println("Student 108 present: "
                + isPresent(attendance, 108));
        System.out.println("Total Present: "
                + getAttendanceCount(attendance));
    }
}
