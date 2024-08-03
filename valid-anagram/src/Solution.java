import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(final String s, final String t) {
        final Map<Character, Integer> characterCount = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }
        for (int j = 0; j < t.length(); j++) {
            final char c = t.charAt(j);
            if (!characterCount.containsKey(c) || characterCount.get(c) <= 0) {
                return false;
            }
            characterCount.put(c, characterCount.get(c) - 1);
        }
        return true;
    }
}