/*
You are given an array arr[] of non-negative integers. 
Your task is to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements.
The operation must be performed in place, meaning you should not use extra space for another array.

Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: [1, 2, 4, 3, 5, 0, 0, 0]

Input: arr[] = [10, 20, 30]
Output: [10, 20, 30]

Input: arr[] = [0, 0]
Output: [0, 0]
*/
import java.util.stream.IntStream;

public class ZerosToEnd{
    public static void main(String[] args) {
        int[] arr = {1,2,0,4,3,0,5,0};
        zerosToEnd(arr);
        System.out.println("Filtered array: ");
        IntStream.of(arr).forEach(System.out::println);
    }
    private static void zerosToEnd(int[] arr){
        int p=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                swap(arr,p,i);
                p++;
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}