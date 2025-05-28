class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[][] nums = {
            {1,1,0,1,1,1},
            {1,0,1,1,0,1}
        };
        int[] expectedAnswer = {3,2};
        for(int i=0;i<expectedAnswer.length;i++){
            System.out.println("Test case "+ (i+1) 
            + "\n Current value: "+ consecutiveOnes(nums[i]) + "\n Expected value: "+expectedAnswer[i]);
        }
        
    }
    private static int consecutiveOnes(int[] arr){
        int ans=0,ones=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                ones=0;
            }else{
                ones++;
                ans=Math.max(ans,ones);
            }
        }
        return ans;
    }
}
