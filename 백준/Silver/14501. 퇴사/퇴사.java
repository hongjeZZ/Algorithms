import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dp = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] timePay = new int[N + 1][2];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            timePay[i][0] = Integer.parseInt(st.nextToken());   // 시간
            timePay[i][1] = Integer.parseInt(st.nextToken());   // 보수
        }

        // 1일부터 N일까지 반복
        for (int i = 1; i < N + 1; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            
            int time = timePay[i][0];
            int pay = timePay[i][1];
            dp[i + time] = Math.max(dp[i + time], dp[i] + pay);
        }

        System.out.println(dp[N + 1]);
    }
}
