import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];
        int[] value = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 50];

        // 1일부터 N일까지 반복
        for (int i = 1; i < N + 1; i++) {
            // 미선택
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);

            // 선택
            dp[i + time[i]] = Math.max(dp[i] + value[i], dp[i + time[i]]);
        }

        System.out.println(dp[N + 1]);
    }
}