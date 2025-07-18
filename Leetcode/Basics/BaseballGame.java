import java.util.ArrayDeque;
import java.util.Deque;

/**
You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.

You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

An integer x.
Record a new score of x.
'+'.
Record a new score that is the sum of the previous two scores.
'D'.
Record a new score that is the double of the previous score.
'C'.
Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.

Example 1:

Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.
 */
class BaseballGame{
    public static void main(String[] args) {
        String[][] inputs = {
            {"5","2","C","D","+"},
            {"5","-2","4","C","D","9","+","+"},
            {"1","C"}
        };
        int[] expectedOutputs = {30,27,0};
        for(int i=0;i<expectedOutputs.length;i++){
            System.out.println("Test case: "+ (i+1));
            System.out.println("Your output: "+ calPoints(inputs[i]));
            System.out.println("Expected output: "+ expectedOutputs[i]);
        }
    }
    private static int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op : operations) {
            switch (op) {
                case "+" -> {
                    int last = stack.removeLast();
                    int secondLast = stack.peekLast();
                    int sum = last + secondLast;
                    stack.addLast(last); // push back last
                    stack.addLast(sum);  // push the new sum
                }
                case "D" -> stack.addLast(stack.peekLast() * 2);
                case "C" -> stack.removeLast();
                default -> stack.addLast(Integer.parseInt(op));
            }
        }

        int totalScore = 0;
        for (int score : stack) {
            totalScore += score;
        }

        return totalScore;
    }
}