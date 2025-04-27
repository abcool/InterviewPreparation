/* 
Given an array of positive integers arr[], return the second largest element from the array. 
If the second largest element doesn't exist then return -1.
Note: The second largest element should not be equal to the largest element.
Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.
Input: arr[] = [10, 10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist.
*/
class SecondLargestInArray{
    public static void main(String[] args) {
        int[] arr1 = {12, 35, 1, 10, 34, 1};
        int[] arr2 = {10, 5, 10};
        int[] arr3 = {10, 10, 10};
        System.out.println("Second largest in "+ arr1 + " is: "+ getSecondLargest(arr1));
        System.out.println("Second largest in "+ arr2 + " is: "+ getSecondLargest(arr2));
        System.out.println("Second largest in "+ arr3 + " is: "+ getSecondLargest(arr3));
    }
    private static int getSecondLargest(int[] arr){
        int second=-1,largest=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[largest]){
                second=largest;
                largest=i;
            }else if(arr[i]!=arr[largest]){
                if(second==-1 || arr[i]>arr[second])
                    second=i;
            }
        }
        return second==-1?-1:arr[second];
    }
}