/*
Given a sorted array arr. Return the size of the modified array which contains only distinct elements.
Note:
1. Don't use set or HashMap to solve the problem.
2. You must return the modified array size only where distinct elements are present and modify the original array such that all the distinct elements come at the beginning of the original array.

Input: arr = [2, 2, 2, 2, 2]
Output: [2]
Explanation: After removing all the duplicates only one instance of 2 will remain 
i.e. [2] so modified array will contains 2 at first position and you should return 1 after modifying the array.
*/
class RemoveDuplicates{
    public static void main(String[] args) {
        int[] arr = {2,2,2,2};
        System.out.println("Original array size:" + arr.length);
        System.out.println("Size post removing duplicates: "+ removeDuplicates(arr));
        int[] arr2 = {2,2,3,4};
        System.out.println("Original array size:" + arr2.length);
        System.out.println("Size post removing duplicates: "+ removeDuplicates(arr2));
    }
    private static int removeDuplicates(int[] arr){
        int ans =1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[ans-1]){
                arr[ans]=arr[i];
                ans++;
            }
        }
        return ans;
    }
}