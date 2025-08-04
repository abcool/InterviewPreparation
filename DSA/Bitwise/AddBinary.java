import java.math.BigInteger;

class AddBinary{
    public static void main(String[] args) {
        String[] a = {"11","1010"};
        String[] b = {"1","1011"};
        String[] expectedOutput = {"100","10101"};
        for(int i=0;i<expectedOutput.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ addBinary(a[i], b[i]));
            System.out.println("Expected output: "+ expectedOutput[i]);
        }
    }

    private static String addBinary(String a, String b) {
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);

        BigInteger result = BigInteger.ZERO;
        BigInteger carry = BigInteger.ZERO;
        int k = 0;

        BigInteger ONE = BigInteger.ONE;
        BigInteger ZERO = BigInteger.ZERO;

        while (num1.compareTo(ZERO) > 0 || num2.compareTo(ZERO) > 0 || carry.compareTo(ZERO) > 0) {
            BigInteger bit1 = num1.and(ONE);
            BigInteger bit2 = num2.and(ONE);
            BigInteger sum = bit1.add(bit2).add(carry);

            if (sum.and(ONE).equals(ONE)) {
                result = result.or(ONE.shiftLeft(k));
            }

            carry = sum.shiftRight(1);
            num1 = num1.shiftRight(1);
            num2 = num2.shiftRight(1);
            k++;
        }

        return result.toString(2); // Return binary string
    }
}