
import java.util.Arrays;
import java.util.Scanner;

public class PrimeNoUptoN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scan.nextInt();
        scan.close();
        System.out.println("All prime numbers upto n are:");
        primeNumbersUptoN(n);
    }
    private static void primeNumbersUptoN(int n){
        boolean[] flagArr = new boolean[n+1];
        Arrays.fill(flagArr, true);
        for(int i=2;i<=n;i++){
            if(flagArr[i]){
                    System.out.println(i);
                    for(int j=i*i; j<=n;j=j+i){
                        flagArr[j]=false;
                    }
            }
        }
    }
}
