import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {

        final Map<String, List<String>> anagramsMap = new HashMap<>();
        for (final String str : strs) {
            final char[] characters = str.toCharArray();
            Arrays.sort(characters);
            final String s = Arrays.toString(characters);
            final List<String> anagrams = anagramsMap.getOrDefault(s, new ArrayList<>());
            anagrams.add(str);
            anagramsMap.put(s, anagrams);
        }

        return new ArrayList<>(anagramsMap.values());
    }
}