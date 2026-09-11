import java.util.Scanner;
class Student{
    int total;
    int subjects;

    Student(int subjects) throws Exception{
        if(subjects <= 0){
            throw new Exception("Number of subjects must be greater than 0.");
        }

        this.subjects = subjects;
    }

    void addMarks(int marks) throws Exception{
        if(marks<0 || marks > 100){
            throw new Exception("Marks must be between 0 and 100.");
        }
        total = total + marks;
    }

    void displayResult(){

        double average = total / (double) subjects;

        System.out.println("Student Result");
        System.out.println("Total Marks : "+ total);
        System.out.println("Average Makrs : " + average);
    }
}



public class StudentResult1 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        try{
            System.out.print("Enter number of Subjects: ");
            int subjects = sc.nextInt();

            Student student = new Student(subjects);

            for(int i=1;i<=subjects;i++){
                System.out.print("Enter marks for subjects:" + i + " :");
                int marks = sc.nextInt();

                student.addMarks(marks);
            }
            student.displayResult();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
    
}
