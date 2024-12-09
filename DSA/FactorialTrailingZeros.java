// Given a number n, count trailing zeros in factorial(n)

import java.util.Scanner;

public class FactorialTrailingZeros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Enter a number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println(" Trailing zeros in factorial(" +n +"): "+ trailingZeros(n));
    }
    private static int trailingZeros(int n){
        int count = 0;
        for(int i=5;i<=n;i=i*5){
            count = count + (n/i);
        }
        return count;
    }
}
