class MonotonicArray{
    public static void main(String[] args) {
        int[][] inputs ={
            {1,2,2,3},
            {6,5,4,4},
            {1,3,2},
            {3,2,1,3},
            {1,1,1,1}
        };
        boolean[] expectedOutputs = {true,true,false,false,true};
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ isMonotonic(inputs[i]));
            System.out.println("Expected output: "+ expectedOutputs[i]);
        }
    }
    private static boolean isMonotonic(int[] nums) {
        boolean isIncreasing=false,isDecreasing=false;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]) isIncreasing=true;
            if(nums[i]<nums[i-1]) isDecreasing=true;

            if(isIncreasing && isDecreasing) return false;
        }
        return true;
    }
}