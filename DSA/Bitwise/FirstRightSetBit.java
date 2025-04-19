/*
Given an integer n. The task is to return the position of the first set bit found from the right side in the binary representation of the number.
Note: If there is no set bit in the integer N, then return 0 from the function.  
Input: n = 18
Output: 2
Explanation: Binary representation of 18 is 010010,the first set bit from the right side is at position 2. 
*/
//{ Driver Code Starts
//Initial Template for Java

import java.lang.*;
import java.util.*;

public class FirstRightSetBit {
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
			int n=sc.nextInt();//input n
			System.out.println(getFirstSetBit(n));//calling method
	}
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
            
        // Your code here
        if(n==0) return 0;
        int count=1;
        while((n&1)==0){
            n>>=1;
            count++;
        }
        return count;
    }
}