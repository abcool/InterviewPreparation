import java.text.NumberFormat;
import java.util.Locale;

class AddStringNum{
    public static void main(String[] args) {
        String[] num1 = {"1,234,680","234,680"};
        String[] num2 = {"7,089","5,089"};
        String[] expectedOutput = {"1,241,769","239,769"};
        for(int i=0;i<expectedOutput.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ addCommaSeparated(num1[i], num2[i]));
            System.out.println("Expected output: "+ expectedOutput[i]);
        }
    }
    private static String addCommaSeparated(String num1, String num2){
        num1 = num1.replace(",", "");
        num2 = num2.replace(",", "");
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        return format.format(n1+n2);
    }
}