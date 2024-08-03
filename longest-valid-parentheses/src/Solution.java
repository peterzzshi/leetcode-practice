import java.util.Stack;

class Solution {
    public int longestValidParentheses(final String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int max = 0;
        final Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                max = Math.max(max, i - stack.peek());
            }
        }

        return max;
    }
}