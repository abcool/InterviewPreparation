import java.util.*;
class ReverseArray{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println("Original Array:");
        Arrays.stream(arr).forEach(System.out::print);
        reverseArray(arr);
        System.out.println("\n Reversed Array");
        Arrays.stream(arr).forEach(System.out::print);
    }
    private static void reverseArray(int arr[]) {
        // code here
        int start=0,end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}