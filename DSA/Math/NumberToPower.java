
import java.util.Scanner;

public class NumberToPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scan.nextInt();
        System.out.print("\n Enter it's power: ");
        int p = scan.nextInt();
        scan.close();
        System.out.println(n +" to power: "+ p + " is "+ numberToPower(n,p));
    }
    private static int numberToPower(int n, int p){
        int ans=1;
        while(p>0){
            if(p %2 != 0){ // bit is 1
                ans = ans * n;
            }
            n= n*n;
            p = p>>1; //p/2;
        }
        return ans;
    }
}
