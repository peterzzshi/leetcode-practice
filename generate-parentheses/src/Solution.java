import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(final int n) {
        final List<String> result = new ArrayList<>();
        this.backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(final List<String> result, final StringBuilder current, final int open, final int close, final int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        if (open < max) {
            current.append("(");
            this.backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(")");
            this.backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}