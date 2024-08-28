public class Solution {
    public int majorityElement(final int[] nums) {
        int result = 0;
        int count = 0;

        for (final int num : nums) {
            if (count == 0) {
                result = num;
            }
            count += result == num ? 1 : -1;
        }

        return result;
    }
}