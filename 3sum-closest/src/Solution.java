import java.util.Arrays;

class Solution {
    public int threeSumClosest(final int[] nums, final int target) {

        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;


            while (start < end) {
                final int sum = nums[i] + nums[start] + nums[end];

                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return closest;
    }
}