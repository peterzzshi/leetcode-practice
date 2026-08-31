package com.leetcode.kokoeatingbananas;

class Solution {
    public int minEatingSpeed(final int[] piles, final int h) {

        int min = 1;
        int max = 0;

        for (final int pile : piles) {
            max = Math.max(pile, max);
        }

        while (min < max) {
            final int mid = min + (max - min) / 2;
            if (this.calculateTime(piles, mid) <= h) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    int calculateTime(final int[] piles, final int rate) {
        int result = 0;
        for (final int pile : piles) {
            result += (pile + rate - 1) / rate;
        }
        return result;
    }
}