/*
 * Optimized Approach
You can use Extended Euclidean Algorithm to compute the modular multiplicative inverse. 
The idea is that if a and m are coprime (i.e., gcd(a, m) = 1), then there exist integers x and y such that:
a * x + m * y = gcd(a, m)
For the modular inverse, you are looking for the value of x such that:
a * x ≡ 1 (mod m)
This means x is the modular inverse of a under modulo m.



Explanation of the Code:

extendedGCD(a, m): This method returns an array where:

result[0] is the greatest common divisor (gcd) of a and m.
result[1] is the coefficient x in the equation a * x + m * y = gcd(a, m) (i.e., the modular inverse if gcd == 1).
result[2] is the coefficient y, which we don't use in this case.
Checking GCD: If gcd(a, m) != 1, the modular inverse does not exist, so we return -1.

Modular Inverse: If the inverse exists, x will be negative in some cases. 
We normalize it to a positive value by computing (x % m + m) % m.
When m = 1, the modular inverse cannot exist because every number modulo 1 is 0. 
So for any number a, we can never find a number x such that a * x ≡ 1 (mod 1) since every multiplication result modulo 1 is 0.
when m == 1, which should directly return -1 because no modular inverse exists.

Time Complexity:
The time complexity of the Extended Euclidean Algorithm is O(log(m)), 
which is much more efficient than the O(m) brute force approach.
 */

public class ModuloInverseOptimized {
    public static void main(String[] args) {
        int a = 10,m=17;
        System.out.println("Modular inverse of: "+ a + " is "+ modInverse(a, m));
        a=2;
        m=1;
        System.out.println("Modular inverse of: "+ a + " is "+ modInverse(a, m));
    }

    private static int modInverse(int a, int m) {
        // Special case: If m is 1, return -1 as no modular inverse exists
        if (m == 1) {
            return -1;
        }
    
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
