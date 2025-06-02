/*
 * 
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 * 
 */

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
class TwoSum{
    public static void main(String[] args) {
        int[][] inputArr = {
            {2,7,11,15},
            {3,2,4},
            {3,3}
        };
        int[][] expected ={
            {0,1},
            {1,2},
            {0,1}
        };
        int[] target = {9,6,6};
        for(int i=0;i<expected.length;i++){
            System.out.println("Test case: "+ (i+1)
            + "\n Your output: "+ printArray(twoSum(inputArr[i],target[i]))+ " Expected Output: "+ printArray(expected[i]));
        }
    }
    private static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> complementMap = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            if(complementMap.containsKey(target-nums[i])){
                ans[0] = complementMap.get(target-nums[i]);
                ans[1]=i;break;
            }
            complementMap.put(nums[i], i);
        }
        return ans;
    }
    private static String printArray(int[] arr){
        IntFunction<String> convertToString = num -> String.valueOf(num);
        return Arrays.stream(arr)
        .mapToObj(convertToString)
        .collect(Collectors.joining(","));
    }
}