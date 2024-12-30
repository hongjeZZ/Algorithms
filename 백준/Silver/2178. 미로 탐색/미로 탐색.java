import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];
        distance[0][0] = 1;
        q.offer(new int[]{0, 0});

        // 미로 저장
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs(0, 0);
            }
        }
    }

    static void bfs(int x, int y) {
        // 방문했거나, 벽이라면 즉시 종료
        if (visited[x][y] || map[x][y] == 0) {
            return;
        }

        // 방문 처리
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            x = poll[0];
            y = poll[1];

            if (x == N - 1 && y == M - 1) {
                System.out.println(distance[x][y]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }

                if (!visited[nx][ny] && map[x][y] == 1) {
                    // 방문 처리
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    distance[nx][ny] += distance[x][y] + 1;
                }
            }
        }
    }
}