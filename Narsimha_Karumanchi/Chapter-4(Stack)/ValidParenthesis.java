import java.util.*;

class ValidParenthesis {
    public static void main(String[] args) {
        runTests();
    }

    public boolean isValid(String s) {
        // ignore odd length strings
        if ((s.length() & 1) == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();

        for (char c : ch) {
            switch (c) {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                default -> {
                    if (stack.empty() || stack.pop() != c)
                        return false;
                }
            }
        }

        return stack.empty();
    }

    private static void runTests() {
        String[] inputs = {
                "()",
                "()[]{}",
                "(]",
                "([])",
                "([)]"
        };

        boolean[] expectedOutputs = {
                true,
                true,
                false,
                true,
                false
        };

        ValidParenthesis obj = new ValidParenthesis();

        for (int i = 0; i < inputs.length; i++) {
            System.out.printf(
                    "Test case %d%nInput: %s%nYour Output: %b%nExpected Output: %b%n%n",
                    i + 1,
                    inputs[i],
                    obj.isValid(inputs[i]),
                    expectedOutputs[i]);
        }
    }
}