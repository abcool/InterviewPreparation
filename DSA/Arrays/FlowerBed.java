public class FlowerBed {
    public static void main(String[] args) {
        int[][] inputArr = {
            {1,0,0,0,1},
            {1,0,0,0,1},
            {0},
            {1},
            {1,0,1},
            {0,1,0},
            {0,0,1}
        };
        int[] nArr = {1,2,1,1,1,1,1};
        boolean[] expectedOutput = {true,false,true,false,false,false,true};
        for(int i=0;i<expectedOutput.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ canPlaceFlowers(inputArr[i], nArr[i]));
            System.out.println("Expected output: "+ expectedOutput[i]);
        }
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        int m = flowerbed.length;
        for(int i=0;i<m;i++){
            if(flowerbed[i]==0){
                if(m==1){
                    count++;break;
                }else if(i==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;count++;
                }else if(i==m-1 && flowerbed[i-1]==0){
                    flowerbed[i]=1;count++;
                }else if(i>0 && i<m-1 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;count++;
                }
            }
        }
        return count>=n;
    }
}
