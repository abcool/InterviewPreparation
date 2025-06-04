/*
 Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. 

Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. 

Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 */
public class MaxCircularSubArray {
    public static void main(String[] args) {
        int[][] inputs = {
            {1,-2,3,-2},
            {5,-3,5},
            {-3,-2,-3}
        };
        int[] expectedAns ={3,10,-2};
        for(int i=0;i<expectedAns.length;i++){
            System.out.println("Test case: "+ (i+1)
            + "\n Your output: "+ maxSubarraySumCircular(inputs[i])+ " Expected Output: "+expectedAns[i]);
        }
    }
    private static int maxSubarraySumCircular(int[] nums) {
        int currSum=nums[0],globalMax=nums[0],globalMin=nums[0],totalSum=nums[0];
        for(int i=1;i<nums.length;i++){
            globalMax= Math.max(globalMax, Math.max(nums[i],currSum+nums[i]));
            globalMin= Math.min(globalMin, Math.min(nums[i],currSum+nums[i]));
            totalSum+=nums[i];
        }
        return globalMax<0?globalMax:Math.max(globalMax,totalSum-globalMin);
    }
}
