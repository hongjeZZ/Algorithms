import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[5001];

        dp[0] = 1;
        dp[2] = 1;

        for (int i = 4; i < 5001; i = i + 2) {
            for (int j = 0; j < i; j = j + 2) {
                dp[i] += dp[j] * dp[i - j - 2];
                dp[i] %= 1_000_000_007;
            }
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}