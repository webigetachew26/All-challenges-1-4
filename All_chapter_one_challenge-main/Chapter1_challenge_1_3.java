

import java.util.Random;
import java.util.Scanner;

 class Chapter1_Challenge_1_3 {

    public static void main(String[] args) {
        int playerHealth = 100;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to The Dungeon Game!");
        System.out.println("Your starting health: " + playerHealth);

        for (int room = 1; room <= 5; room++) {
            System.out.println("\nEntering room " + room + "...");

            int event = rand.nextInt(3) + 1; // Generates 1, 2, or 3

            switch (event) {
                case 1: // Trap
                    playerHealth -= 20;
                    System.out.println("A trap sprung! Health is now " + playerHealth + ".");
                    break;
                case 2: // Healing Potion
                    playerHealth += 15;
                    if (playerHealth > 100) {
                        playerHealth = 100; // Cap health at 100
                        System.out.println("You found a healing potion! Health is now 115 -> capped to 100.");
                    } else {
                        System.out.println("You found a healing potion! Health is now " + playerHealth + ".");
                    }
                    break;
                case 3: // Monster
                    System.out.println("A monster appears! Guess a number (1-5) to defeat it:");
                    int monsterNumber = rand.nextInt(5) + 1; // Monster's secret number
                    int playerGuess;
                    do {
                        System.out.print("Your guess: ");
                        playerGuess = scanner.nextInt();
                        if (playerGuess != monsterNumber) {
                            System.out.println("Wrong! Try again:");
                        }
                    } while (playerGuess != monsterNumber);
                    System.out.println("You defeated the monster!");
                    break;
            }

            if (playerHealth <= 0) {
                System.out.println("You have been defeated in room " + room + ".");
                break; // Exit the loop if health reaches 0 or below
            }
        }

        if (playerHealth > 0) {
            System.out.println("\nYou cleared the dungeon! Victorious with " + playerHealth + " health!");
        }

        scanner.close();
    }
}
