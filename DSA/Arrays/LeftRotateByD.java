
import java.util.stream.IntStream;

/* 
Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, 
where d is a positive integer. Do the mentioned change in the array in place.

Input: arr[] = [1, 2, 3, 4, 5], d = 2
Output: [3, 4, 5, 1, 2]

Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]

Input: arr[] = [7, 3, 9, 1], d = 9
Output: [3, 9, 1, 7]

*/
public class LeftRotateByD{
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int d = 3;
        System.out.println("Original Array");
        IntStream.of(arr).forEach(System.out::println);
        leftRotate(arr,d);
        System.out.println("\n Array after rotation");
       IntStream.of(arr).forEach(System.out::println);
    }
    private static void leftRotate(int[] arr, int d){
        int n = arr.length;
        d = d%n; // to handle array index out of bounds
        reverseArray(arr,0,d-1); // reverse first d elements
        reverseArray(arr,d,n-1); // reverse d to n elements
        reverseArray(arr,0,n-1); // reverse whole array elements
    }
    private static void reverseArray(int[] arr, int start, int end){
        while(start<end){
            swap(arr,start,end);
            start++;end--;
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
    }
}