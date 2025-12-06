import java.io.*;
class Factorial{
    public static void main(String[] ar) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number");
        //System.out.println("Numbered entered: "+ br.read());
        int n = Integer.parseInt(br.readLine());
        br.close();
        System.out.println("Factorial of "+ n + " is "+ factorial(n));
    }
    private static int factorial(int n){
        if(n<=1) 
            return 1;
        else
            return n*factorial(n-1);
    }
}