/*
 Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */
import java.util.*;
public class SubArraySumK {
    public static void main(String[] args) {
        int[][] inputs = {
            {1,1,1},
            {1,2,3}
        };
        int[] k = {2,3};
        int[] expectedAns = {2,2};
        for(int i=0;i<expectedAns.length;i++){
            System.out.println("Test case: "+ (i+1)
            + "\n Your output: "+ subarraySum(inputs[i],k[i])+ " Expected Output: "+expectedAns[i]);
        }
    }
    // Logic -> we will find s-k in map and use it to increase count where s is the summ of all array elements upto current element
    private static int subarraySum(int[] nums, int k) {
        int ans=0,s=0;
        Map<Integer,Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // Add 0 with freq 1 in map
        for(int i:nums){
            s+=i; // add current value in array to s
            ans+=prefixSumFreq.getOrDefault(s-k, 0); // if s-k exists in map return the freq & add to ans
            prefixSumFreq.put(s, prefixSumFreq.getOrDefault(s, 0)+1); // if current array element doesn't exist in map, add with freq 1 otherwise increase the freq of the existing
        }
        return ans;
    }
}
