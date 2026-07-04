/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
*/
class TwoSum{
    public static void main(String[] args) {
        int [] numbers = {2,7,11,15};
        int target = 9;
        int[] ans1 = twoSum(numbers,target);
        System.out.printf("%d and %d sum up to %d \n",ans1[0], ans1[1],target);
        int[] numbers2 = {2,3,4};
        target = 6;
        int[] ans2 = twoSum(numbers2,target);
        System.out.printf("%d and %d sum up to %d \n",ans2[0], ans2[1],target);
        int[] numbers3 = {-1,0};
        target = -1;
        int[] ans3 = twoSum(numbers3,target);
        System.out.printf("%d and %d sum up to %d \n",ans3[0], ans3[1],target);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int s=0,e=numbers.length-1;
        int[] ans = new int[2];
        while(s<e){
            int sum = numbers[s]+numbers[e];
            if(sum==target){
                ans[0]=s+1;
                ans[1]=e+1;
                break;
            }
            if(sum<target){
                s++;
            }
            if(sum>target){
                e--;
            }
        }
        return ans;
    }
}