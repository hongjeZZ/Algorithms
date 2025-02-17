import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        System.out.println(dp[N]);
    }
}