/*
You are given a number n. Find the total count of set bits for all numbers from 1 to n (both inclusive).
Input: n = 4
Output: 5
Explanation: For numbers from 1 to 4. 
For 1: 0 0 1 = 1 set bits 
For 2: 0 1 0 = 1 set bits 
For 3: 0 1 1 = 2 set bits 
For 4: 1 0 0 = 1 set bits 
Therefore, the total set bits is 5.
*/
import java.util.Scanner;

class CountSetBitsUptoN{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println(" Count of set bits upto "+n+" are: "+countSetBits(n));
    }
     public static int countSetBits(int n){
    
        // Your code here
        if(n==0) return 0;
        int x = largestPowerOf2(n);
        int bitsTill2X = (1<<(x-1))*x;
        int msb = n - (1<<x) + 1;
        int rest = n - (1<<x);
        int ans = bitsTill2X + msb + countSetBits(rest);
        return ans;
    }
    private static int largestPowerOf2(int n){
        int x=0;
        while((1<<x)<=n){
            x++;
        }
        return x-1;
    }
}