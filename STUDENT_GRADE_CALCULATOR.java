import java.util.Scanner;
public class STUDENT_GRADE_CALCULATOR {


    float percentage;
    static float total_Marks;

    public static float calculateTotalMarks(float[] marksArray) {
      total_Marks = 0;
        for (int i = 0; i < marksArray.length; i++) {
            total_Marks += marksArray[i];
        }
        return total_Marks;
    }
     public static double calculateAveragePercentage(float totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }
    public static char assignGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    public static void displayResults(float totalMarks, double averagePercentage, char grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
       int numSubjects = scanner.nextInt();
        float[] marksArray = new float[numSubjects];

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marksArray[i] = scanner.nextInt();
        }
     float totalMarks = calculateTotalMarks(marksArray);
     double percentage=calculateAveragePercentage(totalMarks,6);
     char grade=assignGrade(percentage);
     displayResults(totalMarks,percentage,grade);


    }
}
