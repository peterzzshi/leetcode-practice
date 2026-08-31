package com.leetcode.kthlargestelementinastream;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargest(final int k, final int[] nums) {
        this.priorityQueue = new PriorityQueue<>();
        this.k = k;

        for (final int num : nums) {
            this.priorityQueue.offer(num);
        }
    }

    public int add(final int val) {
        if (this.priorityQueue.size() < this.k || this.priorityQueue.peek() < val) {
            this.priorityQueue.offer(val);
            if (this.priorityQueue.size() > this.k) {
                this.priorityQueue.poll();
            }
        }
        return this.priorityQueue.peek();
    }
}