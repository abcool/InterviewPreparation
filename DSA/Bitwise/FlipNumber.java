/* 
You are given two numbers a and b. The task is to count the number of bits needed to be flipped to convert a to b.
Input: a = 10, b = 20
Output: 4
Explanation:
a  = 01010
b  = 10100
As we can see, the bits of A that need to be flipped are 01010. If we flip these bits, we get 10100, which is B.
*/
import java.util.Scanner;
class FlipNumber{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int a = scan.nextInt();
        System.out.println("Enter the second number: ");
        int b = scan.nextInt();
        scan.close();
        System.out.println(" The number of bits needed to be flipped to convert a to b are: "+countBitsFlip(a, b));
    }
    public static int countBitsFlip(int a, int b){
        
        // Your code here
        int x = (a ^ b);
        return count(x);
    }
    private static int count(int n){
        int count=0;
        while(n>0){
            n &=(n-1);
            count++;
        }
        return count;
    }
}