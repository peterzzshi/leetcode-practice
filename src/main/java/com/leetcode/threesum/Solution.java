package com.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(final int[] nums) {
        Arrays.sort(nums);

        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {

                final int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    do {
                        start++;
                    } while (start < end && nums[start] == nums[start - 1]);
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}