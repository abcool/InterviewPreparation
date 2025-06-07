/*
 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
import java.util.*;
public class MergeIntervals {

    public static void main(String[] args) {
        int[][][] inputs = {
            {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
            },{
                {1,4},
                {4,5}
            }
        };
        int[][][] expectedOutput = {
            {
                {1,6},
                {8,10},
                {15,18}
            },
            {
                {1,5}
            }
        };
        for(int i=0;i<expectedOutput.length;i++){
            System.out.println("Test case: "+(i+1));
            System.out.println("Your output: "+ print(merge(inputs[i])));
            System.out.println("Expected output: "+ print(expectedOutput[i]));
        }
    }

    private static int[][] merge(int[][] intervals) {
        // if having only 1 interval, return that
        if(intervals.length<=1) return intervals;
        
        Comparator<int[]> arrayComparator = (a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        };
        // First sort the intervals
        Arrays.sort(intervals,arrayComparator);
        // Define ans array
        List<int[]> ans = new ArrayList<>();
        // select first interval
        int[] currInterval = intervals[0];
        // add first to ans
        ans.add(currInterval);
        for(int[] interval:intervals){
            // if starting point of current interval <= ending point of previous interval, update the current interval's ending point
            if(interval[0]<=currInterval[1]){
                currInterval[1] = Math.max(currInterval[1], interval[1]);
            }else{ // create new interval and add to answer
                currInterval = interval;
                ans.add(currInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    private static String print(int[][] arr){
        StringBuilder sb = new StringBuilder();
        for(int[] i:arr){
            sb.append("[ ");
            for (int j = 0; j < i.length; j++) {
                sb.append(i[j]);
                if (j < i.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("] ");
        }
       return sb.toString();
    }
}
