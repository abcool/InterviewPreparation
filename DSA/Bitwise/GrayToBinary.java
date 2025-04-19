/*
Given an integer number n, which is a decimal representation of Gray Code. 
Find the binary equivalent of the Gray Code & return the decimal representation of the binary equivalent. 
Input: 
n = 4
Output: 
7
Explanation:
Given 4, its gray code =  110.
Binary equivalent of the gray code 110 is 100.
Return 7 representing gray code 100.
*/
import java.util.Scanner;
class GrayToBinary{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println("The binary equivalent of the gray code is: " + grayToBinary(n));
    }
    public static int grayToBinary(int n) {
        
        // Your code here
        int ans = n;
        while(n>0){
            n>>=1;
            ans^=n;
        }
        return ans;
    }
}