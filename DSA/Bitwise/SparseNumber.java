
import java.util.Scanner;

/*
Given a number N. The task is to check whether it is sparse or not. 
A number is said to be a sparse number if no two or more consecutive bits are set in the binary representation. 
Input: N = 2
Output: 1
Explanation: Binary Representation of 2 is 10, 
which is not having consecutive set bits. 
So, it is sparse number.
*/
class SparseNumber{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scan.nextInt();
        scan.close();
        if(isSparse(n)){
            System.out.println("The number is sparse.");
        } else {
            System.out.println("The number is not sparse.");
        }
    }
    public static boolean isSparse(int n)
    {
        // Your code here
        if(n==1 || n==0) return true;
        return (n&(n>>1))==0;
    }
}