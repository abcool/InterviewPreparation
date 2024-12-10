
import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(" Prime factors of "+ n + " are: ");
        printPrimeFactors(n);
    }
    private static void printPrimeFactors(int n){
        while(n % 2 == 0) System.out.println("2");
        while(n % 3 == 0) System.out.println(" 3");
        for(int i=5; i*i<=n; i+=6){
            if(n % i == 0) System.out.println(i);
            if((n+2) % i == 0) System.out.println(i+2);
        }
        if ( n > 3)
            System.out.println(n);
    }
}
