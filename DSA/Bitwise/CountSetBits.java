package Bitwise;

import java.util.Scanner;

public class CountSetBits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println(" Number of set bits in "+n+" are: "+countSetBits(n));
        System.out.println(" Number of set bits in "+n+" using lokup table approach are: "+getSetBitsCount(n));
    }
    // Brian Kerringam's Algorithm
    private static int countSetBits(int n){
        int count=0;
        while(n>0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    // lookup table approach
    private static int[] table = new int[256];
    private void initialize(){
        table[0]=0;
        for(int i=1;i<256;i++){
            table[i] = table[i&(i-1)]+1;
        }
    }
    private static int getSetBitsCount(int n){
        return table[n&255]+table[(n>>8)&255]+table[(n>>16)&255]+table[(n>>24)];
    }
 }
