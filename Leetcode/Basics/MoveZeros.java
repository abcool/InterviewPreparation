/*
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 */
import java.util.*;
class MoveZeros{
    public static void main(String[] args) {
        int[][] inputs = {
            {0,1,0,3,12},
            {0}
        };
        int[][] expectedOutputs = {
            {1,3,12,0,0},
            {0}
        };
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            moveZeros(inputs[i]);
            System.out.println("Your output: "+ Arrays.toString(inputs[i]));
            System.out.println("Expected output: "+ Arrays.toString(expectedOutputs[i]));
        }
    }
    private static void moveZeros(int[] nums){
        int p=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[p];
                nums[p]=nums[i];
                nums[i]=temp;
                p++;
            }
        }
    }
}