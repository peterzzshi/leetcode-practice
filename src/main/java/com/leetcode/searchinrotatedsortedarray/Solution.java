package com.leetcode.searchinrotatedsortedarray;

public class Solution {
    public int search(final int[] nums, final int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            final int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {

                if (nums[mid] < target || nums[left] > target) {
                    left = mid + 1;
                } else {
                    right = right - 1;
                }
            } else {
                if (nums[mid] > target || nums[right] < target) {
                    right = right - 1;
                } else {
                    left = left + 1;
                }
            }
        }
        return -1;
    }
}