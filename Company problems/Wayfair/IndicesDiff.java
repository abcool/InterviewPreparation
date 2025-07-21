/*
 * Given na array of heights and integer k, such that if array contains 2 equal values and their indices
 * differ by k or less return true, else return false.
 * For e.g. heights = [1,2,3,1], k=3, return true;
 * heights = [1,0,1,1], k = 1, return true
 * heights = [1,0,0,2,1], k=2, return true
 */

import java .util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class IndicesDiff{
    public static void main(String[] args) {
        Integer[][] heights={
            {1,2,3,1},
            {1,0,1,1},
            {1,0,0,2,1}
        };
        int[] kArr = {3,1,2};
        boolean[] ans = {true,true,true};

        for(int i=0;i<kArr.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ found(Arrays.asList(heights[i]), kArr[i]));
            System.out.println("Expected output: "+ ans[i]);
        }
    }
    private static boolean found(List<Integer> heights, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<heights.size();i++){
            int height = heights.get(i);
            if(map.containsKey(height)){
                int prevIndex = map.get(height);
                if(i-prevIndex<=k)
                    return true;
            }
            map.put(height,i);
        }
        return false;
    }
}