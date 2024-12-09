// Given a number n, check if it is palindrome

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println(" Is "+ n + " palindrome: "+ isPalindrome(n));
    }
    private static boolean isPalindrome(int n){
        int temp=n;
        int rev=0;
        while(temp>0){
            rev = rev*10 + temp % 10;
            temp=temp / 10;
        }
        return (n == rev);
    }
}
