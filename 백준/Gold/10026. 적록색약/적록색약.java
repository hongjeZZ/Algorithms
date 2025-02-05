import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        char[][] specialArr = new char[N][N];
        visited = new boolean[N][N];
        int cnt = 0;
        int specialCnt = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                arr[i][j] = c;

                if (c == 'R') {
                    specialArr[i][j] = 'G';
                } else {
                    specialArr[i][j] = c;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, arr);
                    cnt++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, specialArr);
                    specialCnt++;
                }
            }
        }
        System.out.println(cnt + " " + specialCnt);
    }

    public static void bfs(int i, int j, char[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 범위를 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                // 방문하지 않았고, 같은 색깔일 경우
                if (!visited[nx][ny] && arr[x][y] == arr[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}