import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long mod = 10007;
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(10);
            return ;
        }

        long[][] dp = new long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[2][i] = 10 - i;
        }

        for (int i = 3; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= mod;
            }
        }

        long answer = 0;

        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
        }

        System.out.println(answer % mod);
    }
}