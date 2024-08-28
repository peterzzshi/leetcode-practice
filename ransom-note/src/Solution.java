public class Solution {
    public boolean canConstruct(final String ransomNote, final String magazine) {
        final int[] magazineChars = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            magazineChars[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            magazineChars[ransomNote.charAt(i) - 'a']--;
            if (magazineChars[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}