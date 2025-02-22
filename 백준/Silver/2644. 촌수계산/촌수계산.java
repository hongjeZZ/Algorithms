import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int start = sc.nextInt();
        int target = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        int result = bfs(start, target, n);
        System.out.println(result);

        sc.close();
    }

    static int bfs(int start, int target, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];

            if (node == target) {
                return depth;
            }

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth + 1});
                }
            }
        }
        return -1;
    }
}