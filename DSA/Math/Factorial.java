/* Given a number n, find factorial of n */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] ar) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter a number");
    int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println("Factorial of "+ n + " is "+getFactorial(n));
    System.out.println("Factorial(Recursive) of "+ n + " is "+ getFactorialRecursive(n));
    }
    private static int getFactorial(int n){
        int f =1;
        for(int i=2;i<=n;i++){
            f=f*i;
        }
        return f;
    }
    private static int getFactorialRecursive(int n){
        if(n==1) return 1;
        return n*getFactorial(n-1);
    }

}

