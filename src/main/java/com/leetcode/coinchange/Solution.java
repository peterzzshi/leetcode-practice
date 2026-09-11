package com.leetcode.coinchange;

import java.util.Arrays;

public class Solution {

    public int coinChange(final int[] coins, final int amount) {

        final int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (final int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount];
    }
}
