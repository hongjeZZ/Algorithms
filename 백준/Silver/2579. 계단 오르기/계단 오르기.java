import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 계단 점수 저장
        int[] stair = new int[T + 1];

        for (int i = 1; i < T + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (T == 1) {
            System.out.println(stair[1]);
            return;
        } else if (T == 2) {
            System.out.println(stair[1] + stair[2]);
            return;
        }

        int[] dp = new int[T + 1];

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];

        for (int i = 3; i < T + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
        }

        System.out.println(dp[T]);
    }
}