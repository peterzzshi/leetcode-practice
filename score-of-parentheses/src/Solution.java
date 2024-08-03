import java.util.Stack;

class Solution {
    public int scoreOfParentheses(final String s) {
        final Stack<Integer> stack = new Stack<>();

        int score = 0;
        for (final char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + (score == 0 ? 1 : 2 * score);
            }
        }
        return score;
    }
}