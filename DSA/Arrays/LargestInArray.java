
import java.util.Scanner;

class LargestInArray{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = scan.nextInt();
        int[] array = new int[n];
        System.out.println("Enter array elements: ");
        for(int i=0;i<n;i++){
            array[i] = scan.nextInt();
        }
        scan.close();
        System.out.println("Largest element in array: "+ getLargest(array));
    }
    private static int getLargest(int[] arr){
        if(arr.length<2) return arr[0];
        int largest = arr[0];
        for(int e:arr){
            if(e>largest) largest = e;
        }
        return largest;
    }
}