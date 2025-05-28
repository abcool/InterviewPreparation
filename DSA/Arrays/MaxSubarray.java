/*
Kandane's Algorithm
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

 */
class MaxSubarray {
    public static void main(String[] args) {
        int[][] inputs = {
            {-2,1,-3,4,-1,2,1,-5,4},
            {1},
            {5,4,-1,7,8}
        };
        int[] expected={6,1,23};
        for(int i=0;i<expected.length;i++){
            System.out.println("Test case: "+(i+1) 
            +" \n Your output: "+ maxSubArray(inputs[i])
            +"\n Expected output: "+ expected[i]);
        }
    }
    private static int maxSubArray(int[] nums) {
        int currSum=nums[0],ans=nums[0];
        for(int i=1;i<nums.length;i++){
            currSum = Math.max(nums[i], nums[i]+currSum);
            ans = Math.max(ans, currSum);
        }
        return ans;
    }
}
