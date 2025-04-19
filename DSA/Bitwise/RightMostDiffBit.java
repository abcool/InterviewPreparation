
import java.util.Scanner;

/*
Given two numbers m and n. The task is to find the position of the rightmost different bit in the binary representation of numbers. 
If both m and n are the same then return -1 in this case.
Input: m = 11, n = 9
Output: 2
Explanation: Binary representation of the given numbers are: 1011 and 1001, 2nd bit from right is different.
*/
class RightMostDiffBit{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int m = scan.nextInt();
        System.out.println("Enter the second number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println(" The position of rightmost different bit is: "+posOfRightMostDiffBit(m, n));
    }
    public static int posOfRightMostDiffBit(int m, int n) {

        // Your code here
        if(m==n) return -1;
        int x = (m ^ n);
        int count=1;
        while((x&1)==0){
            x>>=1;count++;
        }
        return count;
    }
}