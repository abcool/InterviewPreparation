/*
Given an array arr[] consisting of only 0's and 1's. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.

Examples :

Input: arr[] = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
Explanation:  After segregation, all the 0's are on the left and 1's are on the right. Modified array will be [0, 0, 0, 0, 0, 1, 1, 1, 1, 1].
Input: arr[] = [1, 1]
Output: [1, 1]
Explanation: There are no 0s in the given array, so the modified array is [1, 1]
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 1

*/
import java.util.Arrays;
class Sort0s1s{
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,0,1,1,1,0};
        segregate0and1(arr);
        Arrays.stream(arr).forEach(x-> System.out.print(x + " "));
        System.out.println("");
        int [] arr2 = {1, 1};
        segregate0and1(arr2);
        Arrays.stream(arr2).forEach(x-> System.out.print(x + " "));
        System.out.println("");
    }
    private static void segregate0and1(int[] arr) {
       
        int left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]==0){
                left++;
            }else if(arr[right]==1){
                right--;
            }else{
                swap(arr,left,right);
                left++;right--;
            }
        }
    }
    
    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}