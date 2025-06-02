
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class KthLargestInArray{
    public static void main(String[] args) {
        int[] arr1 = {12, 35, 1, 10, 34, 1};
        System.out.println("Second largest in "+ printArray(arr1) + " is: "+ getKthLargest(arr1,2));
        System.out.println("Third largest in "+ printArray(arr1) + " is: "+ getKthLargest(arr1,3));
        System.out.println("Fourth largest in "+ printArray(arr1) + " is: "+ getKthLargest(arr1,4));
    }
    private static int getKthLargest(int[] arr, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1);
        for(int i=0;i<arr.length;i++){
            queue.add(arr[i]);
            if(queue.size()>k)
                queue.remove();
        }
        return queue.remove();
    }
    private static String printArray(int[] arr){
        return Stream.of(arr).map(String::valueOf)
        .collect(Collectors.joining(","));
    }
}