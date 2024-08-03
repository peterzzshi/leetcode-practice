class Solution {
    public boolean canBeValid(final String s, final String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        final int n = s.length();

        int potentialOpens = 0;
        int fixedCloses = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                potentialOpens++;
            } else {
                fixedCloses++;
            }
            if (fixedCloses > potentialOpens) {
                return false;
            }
        }

        int potentialCloses = 0;
        int fixedOpens = 0;

        for (int j = n - 1; j > 0; j--) {
            if (s.charAt(j) == ')' || locked.charAt(j) == '0') {
                potentialCloses++;
            } else {
                fixedOpens++;
            }
            if (fixedOpens > potentialCloses) {
                return false;
            }
        }

        return true;
    }
}