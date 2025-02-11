import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][N][3];
        dp[0][1][0] = 1;

        for (int x = 0; x < N; x++) {
            for (int y = 1; y < N; y++) {
                if (arr[x][y] == 1) {
                    continue;
                }

                // 1. 가로 방향 (좌측에서 오는 경우)
                dp[x][y][0] += dp[x][y - 1][0] + dp[x][y - 1][2];

                // 2. 세로 방향 (위쪽에서 오는 경우)
                if (x - 1 >= 0) {
                    dp[x][y][1] += dp[x - 1][y][1] + dp[x - 1][y][2];
                }

                // 3. 대각선 방향 (대각선, 가로, 세로 모두 확인 필요)
                if (x - 1 >= 0 && arr[x - 1][y] == 0 && arr[x][y - 1] == 0) {
                    dp[x][y][2] += dp[x - 1][y - 1][0] + dp[x - 1][y - 1][1] + dp[x - 1][y - 1][2];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += dp[N - 1][N - 1][i];
        }
        System.out.println(sum);
    }
}