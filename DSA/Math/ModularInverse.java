/*
 * Given two integers ‘a’ and ‘m’. The task is to find the smallest modular multiplicative inverse of ‘a’ under modulo ‘m’. 
 * if it does not exist then return -1.
 * 
Input:
a = 3
m = 11
Output: 4
Explanation: Since (4*3) mod 11 = 1, 4 
is modulo inverse of 3. One might think,
15 also as a valid output as "(15*3)
mod 11"  is also 1, but 15 is not in 
ring {0, 1, 2, ... 10}, so not valid.

Input:
a = 10
m = 17
Output: 12
Explanation: Since (12*10) mod 17 = 1,
12 is the modulo inverse of 10.
 */

public class ModularInverse {
    public static void main(String[] args) {
        int a = 10,m=17;
        System.out.println("Modular inverse of a is "+ modInverse(a, m));
    }

    private static int modInverse(int a, int m) {
        // Compute the greatest common divisor of a and m
        int[] result = extendedGCD(a, m);
        int gcd = result[0];
        int x = result[1];  // The coefficient for a in the equation a * x + m * y = gcd
    
        if (gcd != 1) {
            // If the GCD is not 1, then inverse doesn't exist
            return -1;
        }
    
        // Ensure the result is positive
        return (x % m + m) % m;
    }

    private static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};  // GCD, x, y
        } else {
            int[] result = extendedGCD(b, a % b);
            int gcd = result[0];
            int x1 = result[1];
            int y1 = result[2];
    
            // Update x and y
            int x = y1;
            int y = x1 - (a / b) * y1;
    
            return new int[]{gcd, x, y};
        }
    }

}
