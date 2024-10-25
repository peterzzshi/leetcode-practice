import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(final int[] nums) {

        final Set<Integer> numbers = new HashSet<>();
        for (final int num : nums) {
            numbers.add(num);
        }

        int longestStreak = 0;

        for (final int num : nums) {
            if (!numbers.contains(num - 1)) {
                int currentNumber = num;
                int currentStreak = 1;
                while (numbers.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}