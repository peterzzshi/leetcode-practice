import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(final int[] temperatures) {
        final int length = temperatures.length;
        final int[] result = new int[length];

        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }

        return result;
    }
}