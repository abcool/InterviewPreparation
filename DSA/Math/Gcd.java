
import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int n1 = scan.nextInt();
        System.out.println("Enter second number: ");
        int n2 = scan.nextInt();
        scan.close();
        System.out.println("GCD of "+ n1 +" , "+ n2 +" : "+ getgcd(n1,n2));
    }
    private static int getgcd(int n, int m){
        if((n % m)==0 )
            return m;
        return getgcd(m,(n%m));
    } 
}
