import java.util.ArrayList;
import java.util.List;

class SpiralTraversal{
    public static void main(String[] args) {
        int[][][] inputs = {
            {
                {1,2,3},
                {4,5,6},
                {7,8,9}
            },
            {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
            }
        };
        List<List<Integer>> expectedAns = List.of(
            List.of(1,2,3,6,9,8,7,4,5),
            List.of(1,2,3,4,8,12,11,10,9,5,6,7)
        );

        for(int i=0;i<expectedAns.size();i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ spiralOrder(inputs[i]));
            System.out.println("Expected output: "+ expectedAns.get(i));
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        int startRow = 0, startCol=0,endRow=r-1,endCol=c-1;
        while(startRow<=endRow && startCol<=endCol){
            //top
            for(int i=startCol;i<=endCol;i++){
                ans.add(matrix[startRow][i]);
            }
            //right
            for(int i=startRow+1;i<=endRow;i++){
                ans.add(matrix[i][endCol]);
            }
            //bottom
            for(int i=endCol-1;i>=startCol;i--){
                if(startRow==endRow)break;
                ans.add(matrix[endRow][i]);
            }
            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol)break;
                ans.add(matrix[i][startCol]);
            }
            startRow++;startCol++;
            endRow--;endCol--;
        }
        return ans;
    }
}