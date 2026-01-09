

import java.util.Scanner;

public class Chapter1_Challenge_1_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int crypticMessage = input.nextInt();

        // Extract the last digit
        int lastDigit = crypticMessage % 10;

        // Extract the first digit
        // Determine the number of digits in the input
        int numberOfDigits = (int) Math.floor(Math.log10(crypticMessage)) + 1;
        // Calculate the divisor to get the first digit
        int divisorForFirstDigit = (int) Math.pow(10, numberOfDigits - 1);
        int firstDigit = crypticMessage / divisorForFirstDigit;

        // Find the product of the first and last digit
        int product = firstDigit * lastDigit;

        // Extract the second digit
        // Remove the first digit, then get the first digit of the remaining number
        int numberWithoutFirstDigit = crypticMessage % divisorForFirstDigit;
        int divisorForSecondDigit = (int) Math.pow(10, numberOfDigits - 2);
        int secondDigit = numberWithoutFirstDigit / divisorForSecondDigit;

        // Extract the second-last digit
        // Remove the last digit, then get the last digit of the remaining number
        int numberWithoutLastDigit = crypticMessage / 10;
        int secondLastDigit = numberWithoutLastDigit % 10;

        // Find the sum of the second digit and the second-last digit
        int sum = secondDigit + secondLastDigit;

        // Create the final code by concatenating the product and the sum
        // Convert integers to strings and concatenate
        String finalCodeString = "" + product + sum;
        int finalCode = Integer.parseInt(finalCodeString); // Convert back to integer if needed for output format

        System.out.println("The decrypted code is: " + finalCode);

        input.close();
    }
}
