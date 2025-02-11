import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(white + " " + blue);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        char color = arr[i][j];
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 범위를 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                // 방문했거나 같은 색이 아닌 경우
                if (visited[nx][ny] || color != arr[nx][ny]) {
                    continue;
                }

                // 방문 처리
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                cnt++;
            }
        }

        if (color == 'W') {
            white += cnt * cnt;
        } else {
            blue += cnt * cnt;
        }
    }
}