

import java.io.IOException;
import java.util.Scanner;

public class DigitsInFactorial {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println(" Digits in factorial("+ n + "): "+ digitsInFactorial(n));
    }
    private static int digitsInFactorial(int n){
        double digits=0;
        for(int i=2;i<=n;i++){
            digits+=Math.log10(i);
        }
        return (int) Math.floor(digits) + 1;
    }
}
