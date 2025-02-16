import java.util.*;

public class Main {

    static final int MAX_N = 1_000_000;
    static final int DIV = 1_000_000_009;

    public static void main(String[] args) {
        int[] dp = new int[MAX_N + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= MAX_N; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % DIV + dp[i - 3]) % DIV;
        }

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}