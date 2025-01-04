import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] grape = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];

        if (N == 1) {
            System.out.println(grape[1]);
            return;
        } else if (N == 2) {
            System.out.println(grape[1] + grape[2]);
            return;
        }

        dp[1] = grape[1];
        dp[2] = grape[1] + grape[2];

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + grape[i - 1]) + grape[i]);
        }

        System.out.println(dp[N]);
    }
}