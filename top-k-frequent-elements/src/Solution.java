import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] topKFrequent(final int[] nums, final int k) {

        final Map<Integer, Integer> countMap = new HashMap<>();
        for (final int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        return countMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();

    }
}