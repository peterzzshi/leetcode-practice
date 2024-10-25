public class Solution {
    public int findMin(final int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[end] > nums[start]) {
                return nums[start];
            }
            final int mid = (start + end) / 2;

            if (nums[mid] < nums[start]) {
                end = mid;
            }
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
        }
        return nums[start];
    }
}