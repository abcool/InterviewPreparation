/*
 Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.
 

Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FizzBuzz{
    public static void main(String[] args) {
        int[] input = {3,5,15};
        String[][] expectedOutput={
            {"1","2","Fizz"},
            {"1","2","Fizz","4","Buzz"},
            {"1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"}
        };
        for(int i=0;i<input.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ fizzBuzz(input[i]));
            System.out.println("Expected output: "+ Arrays.toString(expectedOutput[i]));
        }
    }
    public static List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if((i%15)==0) ans.add("FizzBuzz");
            else if((i%3)==0) ans.add("Fizz");
            else if((i%5)==0) ans.add("Buzz");
            else ans.add(String.valueOf(i));
        }
        return ans;
    }
}