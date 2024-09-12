/* Problem Statement: 
 
An online multiplayer game allows N players to play against each other. 
The players have to choose a random number. 
The game begins by choosing two players that have chosen the highest and the lowest number.
The difference between the two selected numbers is calculated and added to the prize money which will be given to the winner at the end of the game.
The player who chose the highest number is removed from the game and player who chose the lowest number would have to replace that number with the calculated difference. 
The game ends when only one player is left.
The winner is awarded the prize money.
If the selected players have the same numbers, then one of the player who has logged in first will remain in the game while the second player will be removed from the game.
The game designer wants to know the total amount of prize money that will be given to the winner of the game.

Write a java program for above where first line of input consists of an integer N representing total number of players.
The second line consists of N space seperated integers representing the random numbers chosen by the N players in the order of log in time.
The program outputs an integer representing the total amount that will be given to the winner of the game.

Sample Input
4
2 3 4 9

Expected Output
11
*/

import java.util.*;

public class MultiplayerGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input
        int N = scanner.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Total prize money
        int totalPrizeMoney = 0;

        // ArrayList to maintain order of players
        ArrayList<Integer> players = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            players.add(i);
        }

        // Game simulation
        while (players.size() > 1) {
            // Identify the player with the highest and lowest number
            int minIndex = 0;
            int maxIndex = 0;
            for (int i = 1; i < players.size(); i++) {
                int currentIndex = players.get(i);
                if (numbers[currentIndex] < numbers[players.get(minIndex)]) {
                    minIndex = i;
                }
                if (numbers[currentIndex] > numbers[players.get(maxIndex)]) {
                    maxIndex = i;
                }
            }

            // Indices of players to be removed or modified
            int minPlayerIndex = players.get(minIndex);
            int maxPlayerIndex = players.get(maxIndex);

            if (minIndex == maxIndex) {
                // Both players have the same number, choose the one who logged in first
                if (minPlayerIndex < maxPlayerIndex) {
                    maxPlayerIndex = minPlayerIndex;
                } else {
                    minPlayerIndex = maxPlayerIndex;
                }
            }

            // Calculate difference and add to prize money
            int difference = numbers[maxPlayerIndex] - numbers[minPlayerIndex];
            totalPrizeMoney += difference;

            // Remove the player with the highest number
            players.remove(maxIndex);
            if (maxIndex < minIndex) {
                minIndex--; // Adjust minIndex if maxIndex was before minIndex
            }

            // Replace the number of the player with the lowest number
            numbers[minPlayerIndex] = difference;
        }

        // Output the total prize money
        System.out.println(totalPrizeMoney);

        scanner.close();
    }
}