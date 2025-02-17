import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String BOJ = "BOJ";
        String line = br.readLine();

        char[] street = new char[N + 1];
        for (int i = 1; i < N + 1; i++) {
            street[i] = line.charAt(i - 1);
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i < N + 1; i++) {
            int lastIndex = BOJ.indexOf(street[i]) - 1 < 0 ? 2 : BOJ.indexOf(street[i]) - 1;

            for (int j = i - 1; j > 0; j--) {
                if (dp[j] != Integer.MAX_VALUE && BOJ.indexOf(street[j]) == lastIndex) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }
            }
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}