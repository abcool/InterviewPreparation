/*
You are given a decimal number N. You need to find the gray code of the number N and convert it into decimal.
Input: N = 7
Output: 4
Explanation: 7 is represented as 111 in 
binary form. The gray code of 111 is 100, 
in the binary form whose decimal equivalent 
is 4. 
*/
import java.util.Scanner;
class BinaryToGray{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println("The gray code of the number is: " + greyConverter(n));
    }
    public static int greyConverter(int n) {
        
        // Your code here
        return (n^(n>>1));
    }
}