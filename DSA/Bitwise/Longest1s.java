
import java.util.Scanner;

/*
Given a number N. Find the length of the longest consecutive 1s in its binary representation.
Input: N = 14
Output: 3
Explanation: 
Binary representation of 14 is 
1110, in which 111 is the longest 
consecutive set bits of length is 3. 
*/
class Longest1s{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println("The length of the longest consecutive 1s in its binary representation is: " + maxConsecutiveOnes(n));
    }
    public static int maxConsecutiveOnes(int N) {
        
        // Your code here
        int count=0;
        while(N>0){
            N = (N&(N>>1));
            count++;
        }
        return count;
    }
}