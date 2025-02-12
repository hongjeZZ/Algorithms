import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {0, -1, 1, 1, -1, 0, -1, 1};
    static int[][] arr;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j});
                } else {
                    dist[i][j] = -1; // 방문하지 않은 곳
                }
            }
        }

        System.out.println(bfs(q));
    }

    public static int bfs(Queue<int[]> q) {
        int maxDistance = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || dist[nx][ny] != -1) {
                    continue;
                }

                // 방문 처리
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
                maxDistance = Math.max(maxDistance, dist[nx][ny]);
            }
        }
        return maxDistance;
    }
}