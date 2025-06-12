import java.util.Arrays;
class RunningSum{
    public static void main(String[] args) {
        int[][] inputs = {
            {1,2,3,4},
            {1,1,1,1,1},
            {3,1,2,10,1}
        };
        int[][] expectedOutputs = {
            {1,3,6,10},
            {1,2,3,4,5},
            {3,4,6,16,17}
        };
        
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ Arrays.toString(runningSum(inputs[i])));
            System.out.println("Expected output: "+ Arrays.toString(expectedOutputs[i]));
        }
    }
        public static int[] runningSum(int[] nums) {
            for(int i=1;i<nums.length;i++){
                nums[i]=nums[i-1]+nums[i];
            }
            return nums;
        }
}