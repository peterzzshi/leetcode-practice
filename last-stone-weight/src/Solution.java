import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(final int[] stones) {
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        for (final int stone : stones) {
            priorityQueue.offer(stone);
        }
        while (priorityQueue.size() > 1) {
            final int stone1 = priorityQueue.poll();
            final int stone2 = priorityQueue.poll();

            if (stone1 != stone2) {
                priorityQueue.offer(Math.abs(stone1 - stone2));
            }
        }

        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }

}