import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperations(final int[] nums) {
        final Set<Integer> uniqueNonZeros = new HashSet<>();
        for (final int num : nums) {
            if (num > 0) {
                uniqueNonZeros.add(num);
            }
        }
        return uniqueNonZeros.size();
    }
}