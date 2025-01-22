import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] timePay = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timePay[i][0] = Integer.parseInt(st.nextToken());   // 시간
            timePay[i][1] = Integer.parseInt(st.nextToken());   // 보수
        }

        // N일에 최대 수익을 갖는 DP 테이블
        // 점화식 : dp[i + time] = max(dp[i] + pay, dp[i + time])
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int time = timePay[i][0];
            int pay = timePay[i][1];

            // 상담을 선택하는 경우
            if (i + time <= N) {
                dp[i + time] = Math.max(dp[i] + pay, dp[i + time]);
            }

            // 상담을 선택하지 않는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}
