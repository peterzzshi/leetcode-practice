package com.leetcode.wordbreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(final String s, final List<String> wordDict) {
        final Set<String> dict = new HashSet<>(wordDict);

        int maxWordLen = 0;
        for (final String word : dict) {
            maxWordLen = Math.max(maxWordLen, word.length());
        }

        final int n = s.length();
        final boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - maxWordLen); j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}