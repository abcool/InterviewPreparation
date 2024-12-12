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
        for(;i>=1;i--){
            if(n%i == 0) System.out.println(n/i);
        }
    }
}
