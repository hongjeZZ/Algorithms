import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static int N;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        // 비의 최대 높이 찾기
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        // 비가 안내리는 경우
        int answer = 1;

        for (int k = 0; k < maxHeight; k++) {
            visited = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문하지 않았고, 해당 도시가 물에 잠기지 않는다면 bfs 탐색
                    if (!visited[i][j] && map[i][j] > k) {
                        // bfs 탐색 횟수를 더함
                        bfs(new int[]{i, j}, k);
                        cnt++;
                    }
                }
            }

            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

    public static void bfs(int[] idx, int height) {
        Queue<int[]> q = new LinkedList<>();
        int x = idx[0];
        int y = idx[1];

        // 방문 처리
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                // 탐색 조건 검증
                if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || visited[nx][ny]) {
                    continue;
                }

                // 물의 높이보다 높다면 방문 처리
                if (map[nx][ny] > height) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}