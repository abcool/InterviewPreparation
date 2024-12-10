
import java.util.Scanner;

public class Lcm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.close();
        System.out.println(" LCM of "+ n +","+m + ": "+getLCM(n, m));
    }
    private static int getLCM(int n, int m){
        return (m * n)/getGcd(n,m);
    }
    private static int getGcd(int n, int m){
        if( m == 0) return n;
        return getGcd(m, n % m);
    }
}
