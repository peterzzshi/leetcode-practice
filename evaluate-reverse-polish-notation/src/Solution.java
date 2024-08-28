import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public int evalRPN(final String[] tokens) {
        final Stack<Integer> stack = new Stack<>();

        final Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for (final String token : tokens) {

            if (operators.contains(token)) {
                final int num1 = stack.pop();
                final int num2 = stack.pop();
                final int result = switch (token) {
                    case "+" -> num2 + num1;
                    case "-" -> num2 - num1;
                    case "*" -> num2 * num1;
                    default -> num2 / num1;
                };
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}