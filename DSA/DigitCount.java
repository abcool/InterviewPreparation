/* Given a number n, return count of digits in n */
import java.util.*;

public class DigitCount{
public static void main(String[] ar){
    Scanner scan = new Scanner(System.in);
    int digit = scan.nextInt();
    scan.close();
    System.out.println("Digit count: "+ count(digit));
}
private static int count(int n){
    int count=0;
    if(n==0)
        return 1;
    while(n!=0){
        count++;
        n=n/10;
    }
    return count;
}

}