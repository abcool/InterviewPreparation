package Bitwise;

import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println(" Is "+n +" power of 2 ? "+ isPowerOfTwo(n));
    }
    // check if input number is power of 2
    private static boolean isPowerOfTwo(int n){
        if(n==0)
            return true;
        return ((n &(n-1))==0);
    }
}
