package com.leetcode.houserobber;

import java.util.Arrays;

class Solution {

    public int rob(final int[] nums) {
        final int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return this.rob(nums, dp, nums.length - 1);
    }

    private int rob(final int[] nums, final int[] dp, final int i) {
        if (i < 0) {
            return 0;
        }

        if (dp[i] >= 0) {
            return dp[i];
        }

        final int result = Math.max(this.rob(nums, dp, i - 2) + nums[i], this.rob(nums, dp, i - 1));
        dp[i] = result;
        return result;
    }
}