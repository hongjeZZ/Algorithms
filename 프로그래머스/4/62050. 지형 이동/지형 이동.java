import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    static int total;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public int solution(int[][] land, int height) {
        int N = land.length;

        total = 0;
        boolean[][] visited = new boolean[N][N];

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.offer(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 이미 방문했다면 종료
            if (visited[node.x][node.y]) {
                continue;
            }

            // 방문 처리
            visited[node.x][node.y] = true;
            total += node.cost;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 이미 방문을 했거나, 범위를 벗어났다면
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                // 비용 계산
                int cost = Math.abs(land[nx][ny] - land[node.x][node.y]);

                if (cost > height) {
                    queue.offer(new Node(nx, ny, cost));
                } else {
                    queue.offer(new Node(nx, ny, 0));
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] array = {
                {1, 4, 8, 10},
                {5, 5, 5, 5},
                {10, 10, 10, 10},
                {10, 10, 10, 20}
        };

        System.out.println(solution.solution(array, 3));
    }
}