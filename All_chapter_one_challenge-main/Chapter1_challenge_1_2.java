
public class EnhancedLott {

    public static void main(String[] args) {
        // Test with the provided numbers and some edge cases
        String[] testNumbers = {
                "12-34-56-78-90",
                "33-44-11-66-22",
                "99-99-99-99-99", // All high digits
        };

        analyzeWinningNumbers(testNumbers);

        // Additional test with invalid format
        System.out.println("\n=== Testing with invalid format ===");
        String[] invalidNumbers = {"12-34-56", "abc-def-ghi", "12-34-56-78-99"};
        analyzeWinningNumbers(invalidNumbers);
    }

    /**
     * Analyzes an array of winning lottery numbers.
     * Expected format: "XX-XX-XX-XX-XX"
     */
    public static void analyzeWinningNumbers(String[] winningNumbers) {
        if (winningNumbers == null || winningNumbers.length == 0) {
            System.out.println("No winning numbers to analyze.");
            return;
        }

        double highestAverage = -1;
        String bestWinningNumber = "";
        boolean foundValidNumber = false;

        System.out.println("=== Lottery Number Analysis ===\n");

        // Using for-each loop for cleaner iteration
        for (String winningNumber : winningNumbers) {
            System.out.println("Analyzing: " + winningNumber);

            try {
                // Remove dashes and validate format
                String cleanNumber = winningNumber.replace("-", "");
                if (cleanNumber.length() != 10) {
                    System.out.println("ERROR: Invalid format. Expected 10 digits after removing dashes.\n");
                    continue;
                }

                // Convert to integer array and calculate sum
                int[] digits = new int[cleanNumber.length()];
                int sum = 0;
                boolean validDigits = true;

                for (int i = 0; i < cleanNumber.length(); i++) {
                    char digitChar = cleanNumber.charAt(i);
                    if (!Character.isDigit(digitChar)) {
                        System.out.println("ERROR: Invalid character '" + digitChar + "' in number.\n");
                        validDigits = false;
                        break;
                    }
                    digits[i] = Character.getNumericValue(digitChar);
                    sum += digits[i];
                }

                if (!validDigits) continue;

                // Calculate average
                double average = (double) sum / digits.length;

                // Print results
                System.out.println("Digit Sum: " + sum + ", Digit Average: " + average + "\n");

                // Update highest average
                if (average > highestAverage) {
                    highestAverage = average;
                    bestWinningNumber = winningNumber;
                }

                foundValidNumber = true;

            } catch (Exception e) {
                System.out.println("ERROR: Unexpected error processing number: " + e.getMessage() + "\n");
            }
        }

        // Display final result if valid numbers were found
        if (foundValidNumber) {
            System.out.println("The winning number with the highest average is: "
                    + bestWinningNumber + " with an average of " + highestAverage);
        } else {
            System.out.println("No valid winning numbers found to analyze.");
        }
    }
}
    


    
    

