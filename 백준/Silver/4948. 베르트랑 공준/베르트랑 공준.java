import java.io.*;
import java.util.*;

public class Main {

    static boolean[] dp = new boolean[123_456 * 2 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        calcPrime();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            sb.append(getSosuCount(N + 1, 2 * N)).append("\n");
        }
        System.out.println(sb);
    }

    public static void calcPrime() {
        Arrays.fill(dp, true);
        dp[0] = dp[1] = false;

        for (int i = 2; i * i < dp.length; i++) {
            if (dp[i]) {
                for (int j = i * i; j < dp.length; j += i) {
                    dp[j] = false;
                }
            }
        }
    }

    public static int getSosuCount(int start, int end) {
        int count = 0;
        for (int i = start; i < end + 1; i++) {
            if (dp[i]) {
                count++;
            }
        }
        return count;
    }
}