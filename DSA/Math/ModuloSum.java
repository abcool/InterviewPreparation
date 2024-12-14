/* 
 * Given two numbers a and b, find the sum of a and b. Since the sum can be very large, find the sum modulo 109+7.
 * 
 Input:
a = 9223372036854775807
b = 9223372036854775807
Output: 582344006

Input:
a = 1000000007
b = 1000000007

 */
import java.util.Scanner;

public class ModuloSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter numbers a and b: ");
        long a = scan.nextLong();
        long b = scan.nextLong();
        scan.close();
        System.out.println("Sum of a and b: "+ sumUnderModulo(a, b));
    }

    private static long sumUnderModulo(long a, long b){
        // code here
        long c = (long) Math.pow(10,9) + 7;
        a = a % c;
        b = b % c;
        return (a+b) % c;
    }   
}
