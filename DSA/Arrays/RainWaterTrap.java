/*
 Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 compute how much water it can trap after raining.
 Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Input: height = [4,2,0,3,2,5]
Output: 9
 */
class RainWaterTrap{
    public static void main(String[] args) {
        int[][] height = {
            {0,1,0,2,1,0,1,3,2,1,2,1},
            {4,2,0,3,2,5}
            };
        int[] result = {6,9};
        for(int i=0;i<result.length;i++){
            System.out.println("Test case "+ (i+1) 
            + "\n Current value: "+ trap(height[i]) 
            + "\n Expected Value: "+ result[i]);
        }
    }
    private static int trap(int[] height) {
        int ans=0;
        int n = height.length;
        // array holding left max values
        int[] lMax = new int[n];
         // array holding right max values
        int[] rMax = new int[n];
        // initialize leftmost element
        lMax[0]=height[0];
        // initialize rightmost element
        rMax[n-1]=height[n-1];
        // fill leftmax array with max values moving left to right
        for(int i=1;i<n;i++){
            lMax[i]=Math.max(height[i],lMax[i-1]);
        }
        // fill rightmax array with max values moving right to left
        for(int i=n-2;i>=0;i--){
            rMax[i]=Math.max(height[i],rMax[i+1]);
        }
        // now calculating water trapped in between leftmost and rightmost pillar
        for(int i=1;i<n-1;i++){
            // take minimum of leftmost & rightmost value and subtract from current to get water trapped at current position
            ans+=Math.min(lMax[i],rMax[i])-height[i];
        }
        return ans;
    }
}