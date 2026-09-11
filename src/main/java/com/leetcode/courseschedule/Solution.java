package com.leetcode.courseschedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static boolean canFinish(final int numCourses, final int[][] prerequisites) {

        final List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        final int[] indegree = new int[numCourses];

        for (final int[] prerequisite : prerequisites) {
            final int course = prerequisite[0];

            graph.get(prerequisite[1]).add(course);
            indegree[course]++;
        }

        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        while (!queue.isEmpty()) {
            final int course = queue.poll();
            completed++;

            for (final int prerequisite : graph.get(course)) {
                indegree[prerequisite]--;
                if (indegree[prerequisite] == 0) {
                    queue.offer(prerequisite);
                }
            }
        }

        return completed == numCourses;
    }
}