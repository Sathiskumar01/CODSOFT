import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = getTotalMarks(scanner, numSubjects);
        double averagePercentage = calculateAverage(totalMarks, numSubjects);

        displayResults(totalMarks, averagePercentage);

        char grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static int getTotalMarks(Scanner scanner, int numSubjects) {
        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.printf("Enter marks obtained in subject %d (out of 100): ", i);
            int marks = scanner.nextInt();

            // Validating marks entered
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks entered. Marks should be between 0 and 100.");
                System.exit(1);
            }

            totalMarks += marks;
        }
        return totalMarks;
    }

    private static double calculateAverage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    private static void displayResults(int totalMarks, double averagePercentage) {
        System.out.println("\nResults:");
        System.out.println("Total Marks Obtained: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else if (averagePercentage >= 50) {
            return 'E';
        } else {
            return 'F'; // Fail
        }
    }
}
