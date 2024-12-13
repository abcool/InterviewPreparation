
import java.util.Scanner;

/*
 * Given positive integers n and k. 
 * The task is to find how many numbers less than or equal to n have numbers of divisors exactly equal to k.
 */
public class NDivisors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scan.nextInt();
        System.out.print("Enter divisor count k: ");
        int k = scan.nextInt();
        scan.close();
        System.out.println(" Numbers less than "+ n +" having exactly "+ k +" divisors are: "+countNumbersWithKDivisors(n, k));
    }
    // Function to count how many numbers <= n have exactly k divisors
    private static int countNumbersWithKDivisors(int n, int k) {
        // Step 1: Precompute the divisor count for each number from 1 to n
        int[] divisorCount = new int[n + 1];  // divisorCount[i] will store the number of divisors of i
        
        // Use a modified sieve to count divisors for each number
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                divisorCount[j]++;  // i is a divisor of all multiples of i
            }
        }
        
        // Step 2: Count how many numbers have exactly k divisors
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (divisorCount[i] == k) {
                result++;
            }
        }
        
        return result;
    }
}
