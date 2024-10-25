public class Solution {
    public int maxSubArray(final int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (final int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}