import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestPalindrome(final String s) {

        int result = 0;
        final Set<Character> chars = new HashSet<>();
        for (final char c : s.toCharArray()) {
            if (!chars.contains(c)) {
                chars.add(c);
            } else {
                chars.remove(c);
                result += 2;
            }
        }
        return chars.isEmpty() ? result : result + 1;
    }

}