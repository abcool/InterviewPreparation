import java.util.Scanner;

public class SetBit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scan.nextInt();
        System.out.println("Enter the bit place to be checked: ");
        int k = scan.nextInt();
        System.out.println(" Is the kth bit set: "+ isKthBitSet(n, k));
        System.out.println(" Is the kth bit set[Right shift approach]: "+ isKthBitSetUsingRightShift(n, k));
    }

    private static boolean isKthBitSet(int n, int k){
        int newNum = (1<<(k-1)); // get the new number 2^(k-1)
        if((newNum&n)!=0)
            return true;
        else
            return false;
    }

    private static boolean isKthBitSetUsingRightShift(int n, int k){
        int newNum = (n>>(k-1)); // n/2^k-1
        if((newNum & 1)!=0)   // check rightmost bit is 1
            return true;
        else
            return false;
    }
}
