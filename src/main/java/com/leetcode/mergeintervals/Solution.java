package com.leetcode.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {

    public int[][] merge(final int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        final Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            final int[] top = stack.peek();

            if (intervals[i][0] > top[1]) {
                stack.push(intervals[i]);
            } else {
                final int[] interval = stack.pop();
                interval[1] = Math.max(interval[1], intervals[i][1]);
                stack.push(interval);
            }
        }

        return stack.toArray(new int[0][]);
    }
}