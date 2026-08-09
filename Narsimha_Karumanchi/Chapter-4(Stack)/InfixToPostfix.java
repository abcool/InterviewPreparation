import java.util.*;

class InfixToPostfix {

    public static void main(String[] args) {
        runTests();
    }

    public static String infixToPostfix(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }

                // Remove '('
                if (!stack.empty()) {
                    stack.pop();
                }
            }

            // Operator
            else {
                while (!stack.empty() && shouldPop(stack.peek(), ch)) {
                    ans.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.empty()) {
            ans.append(stack.pop());
        }

        return ans.toString();
    }

    private static boolean shouldPop(char stackOp, char currentOp) {

        // '(' should never be popped here
        if (stackOp == '(') {
            return false;
        }

        int stackPrecedence = getPrecedence(stackOp);
        int currentPrecedence = getPrecedence(currentOp);

        // Stack operator has higher precedence
        if (stackPrecedence > currentPrecedence) {
            return true;
        }

        // Same precedence:
        // pop only when current operator is left-associative
        return stackPrecedence == currentPrecedence && currentOp != '^';
    }

    private static int getPrecedence(char ch) {
        if (ch == '^')
            return 3;

        if (ch == '*' || ch == '/')
            return 2;

        if (ch == '+' || ch == '-')
            return 1;

        return -1;
    }

    private static void runTests() {

        test("a*(b+c)/d", "abc+*d/");
        test("a+b*c+d", "abc*+d+");
        test("(a+b)*(c+d)", "ab+cd+*");
        test("a^b^c", "abc^^");
        test("a+b*c^d-e", "abcd^*+e-");
        test("(a+b)*c", "ab+c*");
    }

    private static void test(String input, String expected) {

        String actual = infixToPostfix(input);

        if (actual.equals(expected)) {
            System.out.println("PASS: " + input + " -> " + actual);
        } else {
            System.out.println(
                "FAIL: " + input +
                " -> Expected: " + expected +
                ", Actual: " + actual
            );
        }
    }
}