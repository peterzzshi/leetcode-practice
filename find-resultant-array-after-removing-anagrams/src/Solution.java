import java.util.*;

class Solution {
    public List<String> removeAnagrams(final String[] words) {
        final Map<String, List<String>> anagramsMap = new HashMap<>();
        for (final String word : words) {
            final char[] chars = word.toCharArray();
            Arrays.sort(chars);
            final String w = Arrays.toString(chars);
            final List<String> anagrams = anagramsMap.getOrDefault(w, new ArrayList<>());
            anagrams.add(word);
            anagramsMap.put(w, anagrams);
        }

        return new ArrayList<>();
    }
}