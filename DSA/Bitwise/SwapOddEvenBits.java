
import java.util.Scanner;

/* 
Given an unsigned integer N. The task is to swap all odd bits with even bits. 
For example, if the given number is 23 (00010111), it should be converted to 43(00101011). 
Here, every even position bit is swapped with an adjacent bit on the right side(even position bits are highlighted in the binary representation of 23), 
and every odd position bit is swapped with an adjacent on the left side.

Input: N = 23
Output: 43
Explanation: 
Binary representation of the given number 
is 00010111 after swapping 
00101011 = 43 in decimal.
*/
class SwapOddEvenBits{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println("The number after swapping odd and even bits is: " + swapBits(n));
    }
    public static int swapBits(int n) 
    {
	    // Your code
	   int oddBits = (n & (0x55555555));
	   int evenBits = (n & (0xAAAAAAAA));
	   oddBits<<=1;
	   evenBits>>=1;
	   return (oddBits | evenBits);
	}
}