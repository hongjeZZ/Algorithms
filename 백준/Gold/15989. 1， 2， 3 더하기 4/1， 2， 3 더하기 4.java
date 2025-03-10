import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[10_001][3];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for (int i = 4; i < 10_001; i++) {
            dp[i][0] = 1;
            dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
            dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0] + dp[n][1] + dp[n][2]).append("\n");
        }
        System.out.println(sb);
    }
}