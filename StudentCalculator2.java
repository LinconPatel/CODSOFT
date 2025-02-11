import java.util.Scanner;

public class StudentCalculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSubjects;

        // Validate number of subjects
        while (true) {
            System.out.print("Enter the number of subjects: ");
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) break;
                else System.out.println("Number of subjects must be greater than 0.");
            } else {
                System.out.println("Invalid input! Please enter an integer value.");
                scanner.next(); // Clear invalid input
            }
        }

        double[] marks = new double[numSubjects];
        double totalMarks = 0;

        // Input marks with validation
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                if (scanner.hasNextDouble()) {
                    double score = scanner.nextDouble();
                    if (score >= 0 && score <= 100) {
                        marks[i] = score;
                        totalMarks += score;
                        break;
                    } else {
                        System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a numeric value.");
                    scanner.next(); // Clear invalid input
                }
            }
        }

        // Calculate Average Percentage
        double averagePercentage = totalMarks / numSubjects;
        String grade = calculateGrade(averagePercentage);

        // Display results
        System.out.println("\n------ Student Grade Report ------");
        System.out.println("Total Marks Obtained: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Function to determine grade based on percentage
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F (Fail)";
    }
}
