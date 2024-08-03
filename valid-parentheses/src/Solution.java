import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(final String s) {
        final Stack<Character> parentheses = new Stack<>();
        final Map<Character, Character> parenthesesMap = Map.of('(', ')', '[', ']', '{', '}');

        for (final char c : s.toCharArray()) {
            if (!parenthesesMap.containsKey(c)) {
                if (parentheses.empty()) {
                    return false;
                }
                final char opening = parentheses.pop();
                if (!parenthesesMap.get(opening).equals(c)) {
                    return false;
                }
            } else {
                parentheses.add(c);
            }

        }
        return parentheses.empty();
    }
}