import java.util.LinkedList;
import java.util.Queue;

class Solution {

    Queue<int[]> q = new LinkedList<>();
    int N;
    int M;
    boolean[][] visited;
    int[][] distance;
    int[] dx;
    int[] dy;

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;

        visited = new boolean[N][M];
        distance = new int[N][M];
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, 1, -1};

        distance[0][0] = 1;
        bfs(0, 0, maps);

        return distance[N - 1][M - 1] != 0 ? distance[N - 1][M - 1] : -1;
    }

    public void bfs(int x, int y, int[][] maps) {
        // 방문 처리
        q.offer(new int[]{0, 0});
        visited[x][y] = true;
        maps[x][y] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            x = poll[0];
            y = poll[1];

            // 목적지에 도착한 경우 즉시 종료
            if (x == N - 1 && y == M - 1) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 이동 가능 판별
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    // 방문 처리
                    q.offer(new int[]{nx, ny});
                    distance[nx][ny] = distance[x][y] + 1;
                    visited[nx][ny] = true;
                    maps[nx][ny] = 1;
                }
            }
        }
    }
}