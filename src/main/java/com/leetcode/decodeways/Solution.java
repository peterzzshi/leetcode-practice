package com.leetcode.decodeways;


class Solution {
    public int numDecodings(final String s) {

        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        final int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i < s.length() + 1; i++) {

            final int oneDigit = s.charAt(i - 1) - '0';
            final int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit != 0) {
                dp[i] += dp[i - 1];
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}
