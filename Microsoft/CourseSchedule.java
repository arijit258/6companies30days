/**

Q-7: Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.


 */
import java.util.*;

class Solution{
    int scheduledCourses;
    Set<Integer>[] adjacencyList;
    int[] nodeStatus;
    final int NOT_VISITED = 0;
    final int VISITED = 1;
    final int ACYCLIC = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        initialize_adjacencyList(numCourses, prerequisites);
        nodeStatus = new int[numCourses];

        for (int node = 0; node < numCourses; node++) {
            if (nodeStatus[node] == NOT_VISITED) {
                depthFirstSearch(node);
            }
        }
        return scheduledCourses == numCourses;
    }

    public void depthFirstSearch(int node) {

        nodeStatus[node] = VISITED;
        Set<Integer> nextCourses = adjacencyList[node];

        for (int course : nextCourses) {
            if (nodeStatus[course] == NOT_VISITED) {
                depthFirstSearch(course);
            } else if (nodeStatus[course] == VISITED) {
                return;
            }
        }
        scheduledCourses++;
        nodeStatus[node] = ACYCLIC;
    }

    public void initialize_adjacencyList(int numCourses, int[][] prerequisites) {

        adjacencyList = new Set[numCourses];
        int size = prerequisites.length;

        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new HashSet<>();
        }

        for (int i = 0; i < size; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            adjacencyList[from].add(to);
        }
    }
}

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{0,1},{1,0}}));
        System.out.println(new Solution().canFinish(2, new int[][]{{0,1}}));
    }
}
