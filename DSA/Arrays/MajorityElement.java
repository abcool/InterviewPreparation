/*
 Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[][] inputArr = {
            {3,2,3},
            {2,2,1,1,1,2,2}
        };
        int[] expectedAns = {3,2};
        for(int i=0;i<expectedAns.length;i++){
            System.out.println("Test case: "+(i+1));
            System.out.println("Your output: "+ majorityElement(inputArr[i]));
            System.out.println("Expected output: "+ expectedAns[i]);
        }
    }
    private static int majorityElement(int[] nums) {
        int majority=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(count>0){
                if(nums[i]==majority) count++;
                else count--;
            }else{
                majority=nums[i];count=1;
            }
        }
        return majority;
    }
}
