import java.util.Vector;

class ResultSheet {
    private Vector<Integer> marks = new Vector<>();

    public void addMarks(int m) {
        marks.add(m);
    }

    public String getDivision(int m) {
        if (m >= 90) return "Outstanding";
        else if (m >= 75) return "Distinction";
        else if (m >= 60) return "First Division";
        else if (m >= 50) return "Second Division";
        else return "Fail";
    }

    public void displayResult() {
        int passed = 0, failed = 0, sum = 0;
        System.out.printf("%-10s %6s  %s%n", "Student", "Marks", "Result");
        System.out.println("-".repeat(36));
        for (int i = 0; i < marks.size(); i++) {
            int m = marks.get(i);
            System.out.printf("%-10s %6d  %s%n", "Student " + (i + 1), m, getDivision(m));
            sum += m;
            if (m >= 50) passed++; else failed++;
        }
        System.out.println("\nTotal students  : " + marks.size());
        System.out.println("Passed students : " + passed);
        System.out.println("Failed students : " + failed);
        System.out.printf("Class average   : %.2f%n", marks.isEmpty() ? 0 : (double) sum / marks.size());
    }
}

public class UniversityResult {
    public static void main(String[] args) {
        ResultSheet sheet = new ResultSheet();
        sheet.addMarks(92);
        sheet.addMarks(78);
        sheet.addMarks(64);
        sheet.addMarks(53);
        sheet.addMarks(41);
        sheet.addMarks(88);
        sheet.displayResult();
    }
}
