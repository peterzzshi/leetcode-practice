package com.leetcode.houserobber2;

import java.util.Arrays;

class Solution {

  public int rob(final int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    final int[] dp1 = new int[nums.length];
    final int[] dp2 = new int[nums.length];
    Arrays.fill(dp1, -1);
    Arrays.fill(dp2, -1);

    return Math.max(this.rob(nums, dp1, 0, nums.length - 2),
        this.rob(nums, dp2, 1, nums.length - 1));

  }

  private int rob(final int[] nums, final int[] dp, final int start, final int i) {
    if (i < start) {
      return 0;
    }

    if (dp[i] >= 0) {
      return dp[i];
    }

    final int result = Math.max(this.rob(nums, dp, start, i - 2) + nums[i],
        this.rob(nums, dp, start, i - 1));
    dp[i] = result;
    return result;
  }
}