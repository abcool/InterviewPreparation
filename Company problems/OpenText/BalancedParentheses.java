/*
 * Write a java program to check if a given string contains a balance sequence of parenthesis. 
 * In output print an integer representing count of balance pairs if the string is balanced, else print -1
 */

 public class BalancedParentheses {

    public static int countBalancedPairs(String s) {
        int balance = 0;
        int balancedPairs = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                if (balance > 0) {
                    balance--;
                    balancedPairs++;
                } else {
                    // More closing parentheses than opening ones
                    return -1;
                }
            }
        }

        // If balance is zero, parentheses are balanced
        return balance == 0 ? balancedPairs : -1;
    }

    public static void main(String[] args) {
        String input = "(()())"; // You can change this input to test other strings
        int result = countBalancedPairs(input);
        System.out.println(result);
    }
}