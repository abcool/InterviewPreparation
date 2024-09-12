// Flower Sort problem
// Problem Statement: Given an array of n elements and a numberk, sort first k elements in increasing order and rest in decreasing order

import java.util.Arrays;

public class CustomSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 5, 8, 3, 6};
        int k = 4;

        // Call the custom sort function
        int[] result = customSort(arr, k);

        // Print the result
        System.out.println(Arrays.toString(result));
    }

    public static int[] customSort(int[] arr, int k) {
        if (k > arr.length) {
            throw new IllegalArgumentException("k cannot be greater than the length of the array");
        }

        // public static short[] copyOfRange(short[] original, int from, int to)
        // original − This is the array from which a range is to to be copied. 
        // from − This is the initial index of the range to be copied, inclusive. 
        // to − This is the final index of the range to be copied, exclusive.

        // Step 1: Sort the first k elements in increasing order
        int[] firstK = Arrays.copyOfRange(arr, 0, k);
        Arrays.sort(firstK);

        // Step 2: Sort the remaining elements in decreasing order
        int[] rest = Arrays.copyOfRange(arr, k, arr.length);
        Arrays.sort(rest);

        // Reverse the sorted rest array to get decreasing order
        reverseArray(rest);

        // Step 3: Combine the two parts
        int[] result = new int[arr.length];

        // public static void arraycopy (Object srcArray, int srcPosition, Object destArray, int destPosition, int noOfElementsToBeCopied) 
        // srcPosition and destPosition start from index 0
        System.arraycopy(firstK, 0, result, 0, k);
        System.arraycopy(rest, 0, result, k, rest.length);

        return result;
    }

    // Helper method to reverse an array
    private static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}