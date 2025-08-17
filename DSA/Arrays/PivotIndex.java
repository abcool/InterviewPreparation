public class PivotIndex {
    public static void main(String[] args) {
        int[][] inputCases = {
            {1,7,3,6,5,6},
            {1,2,3},
            {2,1,-1}
        };
        int[] expectedOutput = {3,-1,0};
        for(int i=0;i<expectedOutput.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ pivotIndex(inputCases[i]));
            System.out.println("Expected output: "+ expectedOutput[i]);
        }
    }
    private static int pivotIndex(int[] nums) {
        int leftSum=0,rightSum=0,ans=-1;
        for(int i=0;i<nums.length;i++){
            rightSum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            rightSum-=nums[i];
            if(leftSum==rightSum){
                ans=i;break;
            }
            leftSum+=nums[i];
        }
        return ans;
    }
}
