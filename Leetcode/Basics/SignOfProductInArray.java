class SignOfProductInArray{
    public static void main(String[] args) {
        int[][] inputs = {
            {-1,-2,-3,-4,3,2,1},
            {1,5,0,2,-3},
            {-1,1,-1,1,-1}
        };
        int[] expectedOutputs={1,0,-1};
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ arraySign(inputs[i]));
            System.out.println("Expected output: "+ expectedOutputs[i]);
        }
    }
    public static int arraySign(int[] nums) {
       int negFreq=0,zeroFreq=0;
       for(int i:nums){
        if(i<0) negFreq++;
        if(i==0) zeroFreq++;
       }
       if(zeroFreq>=1)
        return 0;
       if((negFreq%2)!=0)
        return -1;
       return 1;
    }
}