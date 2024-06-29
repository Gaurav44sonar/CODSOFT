import java.util.Scanner;

public class Student_Grade_Calculator {
    private int total_subject;
    private int total_marks;
    private double percentage;
    private int[] marks;

    public Scanner sc = new Scanner(System.in);

    public void calculateGrade() {
        System.err.println("Enter the number of subjects: ");
        total_subject = sc.nextInt();

        marks = new int[total_subject];

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Enter marks for subject: " + (i + 1));
            marks[i] = sc.nextInt();

            total_marks += marks[i];
        }

        percentage = total_marks / total_subject;

        System.out.println();
        System.out.println("         Your Marksheet        ");
        System.out.println("Total Marks:\t" + total_marks);
        System.out.println("Percentage:\t" + percentage + "%");

        if (percentage > 35 && percentage <= 60) {
            System.out.println("Grade:\t\tD");
        } else if (percentage > 60 && percentage <= 75) {
            System.out.println("Grade:\t\tC");
        } else if (percentage > 75 && percentage <= 85) {
            System.out.println("Grade:\t\tB");
        } else if (percentage > 85 && percentage <= 100) {
            System.out.println("Grade:\t\tA");
        } else {
            System.out.println("\t\t\tFail");
        }
    }

    public static void main(String[] args) {
        Student_Grade_Calculator student_Grade_Calculator = new Student_Grade_Calculator();
        System.out.println("          STUDENT GRADE CALCULATOR         ");
        System.out.println();
        student_Grade_Calculator.calculateGrade();
    }

}