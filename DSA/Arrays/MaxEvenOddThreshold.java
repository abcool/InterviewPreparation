/*
 * You are given a 0-indexed integer array nums and an integer threshold.

Find the length of the longest subarray of nums starting at index l and ending at index r (0 <= l <= r < nums.length) 

that satisfies the following conditions:

nums[l] % 2 == 0
For all indices i in the range [l, r - 1], nums[i] % 2 != nums[i + 1] % 2
For all indices i in the range [l, r], nums[i] <= threshold
Return an integer denoting the length of the longest such subarray.

Note: A subarray is a contiguous non-empty sequence of elements within an array.
 */

public class MaxEvenOddThreshold {
    public static void main(String[] args) {
        int[][] nums = {
            {3,2,5,4},
            {1,2},
            {2,3,4,5}
        };
        int[] threshold = {5,2,4};
        int[] expectedAns = {3,1,3};
        for(int i=0;i<expectedAns.length;i++){
            System.out.println("Test case: "+ (i+1)
            + "\n Your output: "+ maxEvenOdd(nums[i],threshold[i])+ " Expected Output: "+expectedAns[i]);
        }
    }
    private static int maxEvenOdd(int[] arr, int threshold){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            int curr=0;
            if(arr[i]<=threshold && isEven(arr[i]))
                curr++;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>threshold || (isEven(arr[j]) & isEven(arr[j-1])) || ( !isEven(arr[j]) & !isEven(arr[j-1]) )){
                    break;
                }
                curr++;
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
    private static boolean isEven(int n){
        return (n%2)==0;
    }
}
