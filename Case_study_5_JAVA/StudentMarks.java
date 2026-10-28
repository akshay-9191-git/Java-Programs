import java.util.*;

public class StudentMarks {

    public static void addMarks(List<Integer> marks, int mark) {
        marks.add(mark);
    }

    public static double calculateAverage(List<Integer> marks) {
        if (marks.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.size();
    }

    public static int findHighest(List<Integer> marks) {
        if (marks.isEmpty()) {
            return 0;
        }
        return Collections.max(marks);
    }

    public static void displayMarks(List<Integer> marks) {
        StringBuilder sb = new StringBuilder();
        for (int m : marks) {
            sb.append(m).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();
        addMarks(marks, 78);
        addMarks(marks, 85);
        addMarks(marks, 92);
        addMarks(marks, 67);
        addMarks(marks, 88);
        displayMarks(marks);
        System.out.println("Average: " + calculateAverage(marks));
        System.out.println("Highest: " + findHighest(marks));
    }
}
