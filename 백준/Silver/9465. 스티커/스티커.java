import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 스티커 열 개수
            int[][] sticker = new int[N + 1][2];

            // 스티커 점수 입력
            String[] up = br.readLine().split(" ");
            String[] down = br.readLine().split(" ");

            for (int i = 1; i <= N; i++) {
                sticker[i][0] = Integer.parseInt(up[i - 1]);
                sticker[i][1] = Integer.parseInt(down[i - 1]);
            }

            // DP 배열 초기화
            int[][] dp = new int[N + 1][2];
            dp[1][0] = sticker[1][0];
            dp[1][1] = sticker[1][1];

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + sticker[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + sticker[i][1];
            }

            // 최대 점수 출력
            System.out.println(Math.max(dp[N][0], dp[N][1]));
        }
    }
}