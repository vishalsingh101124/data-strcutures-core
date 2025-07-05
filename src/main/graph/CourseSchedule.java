package main.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        System.out.println(canCourseComplete(numCourses,prerequisites));
    }

    static boolean canCourseComplete(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return true;

        List<Integer>[] adjacencyList = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preReq = prerequisite[1];
            adjacencyList[preReq].add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            for (int neighbor : adjacencyList[course]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return completedCourses == numCourses;
    }

}
