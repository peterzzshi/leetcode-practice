import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(final int[] nums, int k) {

        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (final int num : nums) {
            priorityQueue.offer(num);
        }

        while (k > 1) {
            priorityQueue.poll();
            k--;
        }
        return priorityQueue.poll();
    }
}