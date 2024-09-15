import java.util.ArrayList;
import java.util.Scanner;


// Student Grade Tracker
// Develop a program that allows a teacher to enter
// students' grades and compute their average,
// highest, and lowest scores. You can use arrays or
// ArrayLists to store the student data.


public class StudentTracker {

    static String studentName;
    static double mathMark, engMark, phyMark, histMark, average, max, min;
    static String answer, ans2;

    static ArrayList<String> students = new ArrayList<String>();
    static ArrayList<ArrayList<Double>> allStudentMarks = new ArrayList<ArrayList<Double>>();
    static ArrayList<Double> studentAv = new ArrayList<Double>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        
        do {
            // To store student name
            System.out.print("Enter the Student name: ");
            studentName = input.nextLine();
            students.add(studentName);

            // To store the marks for this student
            ArrayList<Double> studentMarks = new ArrayList<Double>();

            // Collect student marks
            System.out.println("Enter the Physics mark: ");
            phyMark = input.nextDouble();
            studentMarks.add(phyMark);

            System.out.println("Enter the Maths mark: ");
            mathMark = input.nextDouble();
            studentMarks.add(mathMark);

            System.out.println("Enter the English mark: ");
            engMark = input.nextDouble();
            studentMarks.add(engMark);

            System.out.println("Enter the History mark: ");
            histMark = input.nextDouble();
            studentMarks.add(histMark);

            // Calculate average, min, and max for this student
            average = (phyMark + mathMark + engMark + histMark) / 4;
            studentAv.add(average);
            studentMarks.add(average);

             // Store the student's marks
             allStudentMarks.add(studentMarks);

            min = studentMarks.get(0);
            max = studentMarks.get(0);

            for (int i = 1; i < studentMarks.size(); i++) {
                if (studentMarks.get(i) < min) {
                    min = studentMarks.get(i);
                }
                if (studentMarks.get(i) > max) {
                    max = studentMarks.get(i);
                }
            }

            System.out.println("The average for " + studentName + " is: " + average);
            System.out.println("Minimum mark for " + studentName + " is: " + min);
            System.out.println("Maximum mark for " + studentName + " is: " + max);

            // Ask if user wants to add another student
            System.out.println("Do you want to add another student? Type 'y' for yes or 'n' to stop:");
            input.nextLine();  // Consume the newline left by nextDouble()
            answer = input.nextLine();

        } while (answer.equalsIgnoreCase("y"));

        // Ask if user wants to display the list of students
        System.out.println("Do you want to display the list of students? Type 'y' for yes or 'n' for no:");
        ans2 = input.nextLine();
        
        if (ans2.equalsIgnoreCase("y")) {
            System.out.println(" |Name     | Physics | Maths | English | History | Average |");

            for (int j = 0; j < students.size(); j++) {
                System.out.print(students.get(j) + " | ");
                for (int i = 0; i < allStudentMarks.get(j).size(); i++) {
                    System.out.print(allStudentMarks.get(j).get(i) + "    | ");
                }
                System.out.print(studentAv.get(j) + " |");
                System.out.println();
            }
        }

        input.close(); // Close the scanner to avoid resource leak
    }
}
