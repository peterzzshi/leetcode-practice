import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(final int[] nums, final int target) {
        final Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int sub = target - nums[i];
            if (seen.containsKey(sub)) {
                return new int[]{i, seen.get(sub)};
            }
            seen.put(nums[i], i);
        }
        return null;
    }
}