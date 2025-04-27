
import java.io.IOException;

class CheckSortedArray{
    public static void main(String[] args) throws IOException{
       int[] arr = {1,2,3,4,5};
       int[] arr2 = {1,3,2,4};
        System.out.println("Is Array sorted:"+ checkArraySorted(arr));
        System.out.println("Is Array2 sorted:"+ checkArraySorted(arr2));
    }
    private static boolean checkArraySorted(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1])
                return false;
        }
        return true;
    }
}