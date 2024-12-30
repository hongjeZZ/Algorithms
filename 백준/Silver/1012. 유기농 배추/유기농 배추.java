import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int N;
    static int K;
    static int[][] farm;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
            N = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
            K = Integer.parseInt(st.nextToken()); // 배추 위치 정보의 개수

            farm = new int[N][M];
            visited = new boolean[N][M];

            // 배추 위치 저장
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                farm[x][y] = 1;
            }

            count = 0; // 이어진 배추 군집의 개수

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    dfs(j, k, true);
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y, boolean first) {
        if (farm[x][y] == 0 || visited[x][y]) {
            return;
        }

        // 방문 처리
        if (first) {
            count++;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            // 상하좌우 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                continue;
            }

            if (farm[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, false);
            }
        }
    }
}