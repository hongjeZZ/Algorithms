import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char[][] arr = new char[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int endX = Integer.parseInt(st.nextToken()) - 1;
        int endY = Integer.parseInt(st.nextToken()) - 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        dp[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int time = dp[x][y];

            // 도착 시 종료
            if (x == endX && y == endY) {
                System.out.println(time);
                return;
            }

            // 4방향 검사
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= K; j++) {
                    int nx = x + dx[i] * j;
                    int ny = y + dy[i] * j;

                    // 해당 방향으로 갈 수 없다면 종료
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '#') {
                        break;
                    }
                    
                    if (dp[nx][ny] <= time) {
                        break;
                    }

                    // 방문 처리
                    if (dp[nx][ny] > time + 1) {
                        dp[nx][ny] = time + 1;
                        q.offer(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }
        // 이동할 수 없는 경우 -1
        System.out.println(-1);
    }
}