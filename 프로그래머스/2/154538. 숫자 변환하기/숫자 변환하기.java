import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];

        queue.add(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];
            int count = current[1];

            if (num == y) {
                return count;
            }

            int[] nextNums = {num + n, num * 2, num * 3};
            for (int next : nextNums) {
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, count + 1});
                }
            }
        }

        return -1;
    }
}