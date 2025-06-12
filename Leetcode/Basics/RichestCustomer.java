class RichestCustomer{
    public static void main(String[] args) {
        int[][][] inputs = {
            {
                {1,2,3},
                {3,2,1}
            },
            {
                {1,5},
                {7,3},
                {3,5}
            },
            {
                {2,8,7},
                {7,1,3},
                {1,9,5}
            }
        };
        int[] outputs = {6,10,17};
        for(int i=0;i<outputs.length;i++){
            System.out.println("Test case: "+(i+1));
            System.out.println("Your output: "+ maximumWealth(inputs[i]));
            System.out.println("Expected output: "+ outputs[i]);
        }
    }
    public static int maximumWealth(int[][] accounts) {
        int maxWealth=0;
        for(int[] arr:accounts){
            int sum=0;
            for(int i:arr){
                sum+=i;
            }
            maxWealth=Math.max(maxWealth,sum);
        }
        return maxWealth;
    }
}