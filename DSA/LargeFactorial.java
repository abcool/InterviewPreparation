
import java.util.*;
import java.util.stream.Collectors;

public class LargeFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        System.out.println("Factorial of "+ n + " is "+ getFactorial(n));
    }
    private static String getFactorial(int n){
        var list = new ArrayList<Integer>();
        list.add(1);
        for(int i=n;i>0;i--){
            int carry=0;
            for(int j=0;j<list.size();j++){
                int temp = list.get(j)*i+carry;
                list.set(j,temp % 10);
                carry = temp / 10;
            }
            while(carry>0L){
                list.add(carry % 10);
                carry = carry / 10;
            }
        }
        Collections.reverse(list);
        return list.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(""));
    }
}
