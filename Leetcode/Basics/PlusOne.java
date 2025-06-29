import java.util.Arrays;

class PlusOne{
    public static void main(String[] args) {
        int[][] inputs={
            {1,2,3},
            {9},
            {1,2,9},
            {8,9,9},
            {9,9,9}
        };
        int[][] expectedOutputs={
            {1,2,4},
            {1,0},
            {1,3,0},
            {9,0,0},
            {1,0,0,0}
        };
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ Arrays.toString(plusOne(inputs[i])));
            System.out.println("Expected output: "+ Arrays.toString(expectedOutputs[i]));
        }
    }
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;// when you encounter 9 make it zero 
                //as adding 1 to it will make it 0 and carry will be added to previous number
            }else{
                digits[i]++; // if we find non 9 number, increment it and return it
                return digits;
            }
        }
        digits = new int[digits.length+1]; // now if all numbers in array were 9 only
        digits[0]=1; // we just set first as 1 and rest as 0
        return digits;// return expanded array
    }
}