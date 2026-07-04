class DuplicatesInSortedArray{
    public static void main(String[] args) {
        int[][] inputs = {
            {1,1,2},
            {0,0,1,1,1,2,2,3,3,4},
            {1},
            {1,1},
            {1,2},
            {1,2,3}
        };
       int [] outputs = {2,5,1,1,2,3};
       int i=0;
       for(;i<outputs.length;i++){
        var ans = removeDuplicates(inputs[i]);
        if(ans!=outputs[i]){
            System.out.printf("Your output %d expected output %d ", ans, outputs[i]);
            break;
        }
       }
       if(i==outputs.length)
        System.out.println("All test cases passed successfully");
    }
    private static int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 1;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }
}