/* Given a quadratic equation ax2 + bx + c = 0, find its roots. 
If the roots are imaginary, return only one integer -1. 
Always return the roots as the greatest integers less than or equal to the actual roots, 
with the maximum root first followed by the minimum root. 

Input:
a = 1, b = -2, c = 1
Output: 1 1
Explanation:
Roots of equation x2-2x+1 are 1 and 1.

Input:
a = 1, b = -7, c = 12
Output: 4 3
Explanation: Roots of equation x2 - 7x + 12 are 4 and 3.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class QuadraticRoots {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter values of a, b, c ");
        String input = br.readLine();
        int[] inputNums = Arrays.stream(input.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();;
        
        System.out.println(" Roots of "+ inputNums[0]+"x^2 "+inputNums[1]+"x +"+inputNums[2]+ " are: ");
        ArrayList<Integer> ans = quadraticRoots(inputNums[0],inputNums[1],inputNums[2]);
        System.out.println(ans);
    }
    private static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        double d = (b*b) - 4*a*c;
        if(d<0){
            ans.add(-1);
            //ans.add(-1);
            return ans;
        }
        double r1 = (-b + Math.sqrt(d))/(2*a);
        double r2 = (-b - Math.sqrt(d))/(2*a);
        int root1 = (int) Math.floor(r1);
        int root2 = (int) Math.floor(r2);
        if(root1>=root2){
            ans.add((int) root1);
            ans.add((int) root2);
        }else{
            ans.add((int) root2);
            ans.add((int) root1);
        }
        return ans;
    }
}
