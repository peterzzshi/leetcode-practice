import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(final String s) {
        final Map<Character, Integer> characters = new HashMap<>();
        int left = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            final char c = s.charAt(right);
            if (characters.containsKey(c)) {
                left = Math.max(left, characters.get(c) + 1);
            }
            characters.put(c, right);
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}