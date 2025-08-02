
public class ReverseBits {
    public static void main(String[] args) {
        int[] inputs = {43261596, 2147483644};
        int[] expectedOutputs={964176192, 1073741822};

        for(int i=0;i<inputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ reverseBits(inputs[i]));
            System.out.println("Expected output: "+ Integer.toString(expectedOutputs[i], 2));
        }
        
    }
    private static String reverseBits(int n){
        int reverse = 0;
        for(int i=0;i<32;i++){
            reverse<<=1;
            reverse |= (n & 1);
            n>>=1;
        }
        return Integer.toString(reverse,2);
    }
}
