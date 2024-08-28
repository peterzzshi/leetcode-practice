class Solution {
    public boolean isPalindrome(final String s) {
        if (s.isBlank()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {

            final char cStart = s.charAt(start);
            final char cEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(cStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(cEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;

            }
        }
        return true;
    }
}