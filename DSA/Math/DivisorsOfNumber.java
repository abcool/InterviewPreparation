import java.util.Scanner;

public class DivisorsOfNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println("Divisors of "+ n +" are ");
        getDivisors(n);
    }
    private static void getDivisors(int n){
        int i=1;
        for(;i*i<n;i++){
            if(n%i == 0) System.out.println(i);
        }
        // this is to prevent duplicates when pair (n,m) has difference of only 1. 
        // For e.g. number 6 and 2 & 3 will be printed twice
       if(i-(n/i)==1) i--;
       
        for(;i>=1;i--){
            if(n%i == 0) System.out.println(n/i);
        }
    }
}
