package com.leetcode.kclosestpointstoorigin;

import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(final int[][] points, final int k) {

        final PriorityQueue<Coordinate> priorityQueue = new PriorityQueue<>();
        for (final int[] point : points) {
            priorityQueue.offer(new Coordinate(point));
        }

        final int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().toPoint();
        }

        return result;
    }

}

class Coordinate implements Comparable<Coordinate> {
    int x;
    int y;
    int distance;

    Coordinate(final int[] point) {
        this.x = point[0];
        this.y = point[1];
        this.distance = this.x * this.x + this.y * this.y;
    }

    int[] toPoint() {
        final int[] point = new int[2];
        point[0] = this.x;
        point[1] = this.y;
        return point;
    }

    @Override
    public int compareTo(final Coordinate c1) {
        return this.distance - c1.distance;
    }
}