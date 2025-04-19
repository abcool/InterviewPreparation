package Bitwise;
public class OneOddOccurence {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,3,3,3,4,4,6,6};
        System.out.println("One odd number in array is: "+oneOdd(arr));
    }
    private static int oneOdd(int[] arr){
        int ans=arr[0];
        for(int i=1;i<arr.length;i++){
            ans ^=arr[i];
        }
        return ans;
    }
}
