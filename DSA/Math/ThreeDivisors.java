/* 
Given a positive integer value n. 
The task is to find how many numbers less than or equal to n have numbers of divisors exactly equal to 3. 

Input: n = 6
Output: 1
Explanation: The only number less than 6 with 3 divisors is 4 which has 1, 2 and 4 as divisors.

Input: n = 10
Output: 2
Explanation: 4 and 9 have 3 divisors.

Logic: A number has 3 divisors only if it is a perfect square of a prime number. 
It will have 3 divisors: 1, number itself and a perfect square number of a prime 
*/
import java.util.Scanner;

public class ThreeDivisors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: "); 
        int n = scan.nextInt();
        scan.close();
        System.out.print("Number of divisors: "+ divisorCount(n));
    }

    private static int divisorCount(int n){
        int count=0;
        for(int i=2;i*i<=n;i++){
            if(isPrime(i)){
                if(i*i <= n) count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n){
        if(n==1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0) return false;
        }
        return true;
    }
}
