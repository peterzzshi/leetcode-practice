package com.leetcode.longestincreasingsubsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(final int[] nums) {

        final int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        for (final int i : dp) {
            max = Math.max(i, max);
        }

        return max;
    }

}