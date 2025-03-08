import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;

        // Taking input for marks in each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();

            // Ensuring valid input
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks! Enter again (0-100): ");
                marks = scanner.nextInt();
            }
            totalMarks += marks;
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Assigning Grades based on the percentage
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F'; // Fail
        }

        // Displaying the result
        System.out.println("\n📊 Student Grade Report 📊");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        // Closing the scanner
        scanner.close();
    }
}
//Output
/*Enter the number of subjects: 2
Enter marks obtained in Subject 1 (out of 100): 99
Enter marks obtained in Subject 2 (out of 100): 98

? Student Grade Report ?
Total Marks: 197
Average Percentage: 98.5%
Grade: A */
