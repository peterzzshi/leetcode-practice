import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(final int[] nums, final int k) {
        final Map<Integer, Integer> seenIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int currentItem = nums[i];
            if (seenIndex.containsKey(currentItem) && Math.abs(i - seenIndex.get(currentItem)) <= k) {
                return true;
            }
            seenIndex.put(currentItem, i);
        }
        return false;
    }
}