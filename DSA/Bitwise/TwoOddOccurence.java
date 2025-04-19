class TwoOddOccurence{
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
        System.out.println(twoOddNumbers(arr));
    }
    private static int[] twoOddNumbers(int[] arr){
        int x = arr[0];
        for(int i=1;i<arr.length;i++){
            x = x^arr[i];
        }
        int[] ans = new int[2];
        for(int i=1;i<arr.length;i++){
            x^=arr[i];
        }
        int k = (x & (~(x-1)));
        for(int i=0;i<arr.length;i++){
            if((arr[i]&k)!=0){
                ans[0]^=arr[i];
            }else{
                ans[1]^=arr[i];
            }
        }
        return ans;
    }
}