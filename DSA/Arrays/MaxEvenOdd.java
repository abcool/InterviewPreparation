/*
 * Given an input array find the length of maximum sub array containing alternate even odd numbers.
 */

public class MaxEvenOdd {
    public static void main(String[] args) {
        int[][] nums = {
            {5,10,20,6,3,8},
            {1},
            {2,3}
        };
        int[] expctedArr = {3,1,2};
        for(int i=0;i<expctedArr.length;i++){
            System.out.println("Test case: "+ (i+1)
            + "\n Your output: "+ maxEvenOdd(nums[i])+ " Expected Output: "+expctedArr[i]);
        }
        
    }
    private static int maxEvenOdd(int[] arr){
        int ans=1,curr=1;
        for(int i=1;i<arr.length;i++){
            if((isEven(arr[i]) & isEven(arr[i-1])) || (!isEven(arr[i]) & !isEven(arr[i-1]))){
            curr=1;
            }else{
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
