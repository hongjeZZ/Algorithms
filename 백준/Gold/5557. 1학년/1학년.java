import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MAX = 20;
        int MIN = 0;

        int[] arr = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(st.nextToken());

        // i = N - 1, K = 0 ~ 20
        // dp[i][K] = i번째 값까지 계산했을 때, K가 나올 수 있는 경우의 수
        long[][] dp = new long[N - 1][21];
        dp[0][arr[0]] = 1;

        for (int i = 1; i < N - 1; i++) {
            int next = arr[i];

            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    int plus = j + next;
                    int minus = j - next;

                    if (plus <= MAX) {
                        dp[i][plus] += dp[i - 1][j];
                    }
                    if (minus >= MIN) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[N - 2][target]);
    }
}