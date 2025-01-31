import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;
    static int[][] dp = new int[30][30];
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb.append(factorial(M, N)).append("\n");
        }
        System.out.println(sb);
    }

    public static int factorial(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = factorial(n - 1, r - 1) + factorial(n - 1, r);
    }
}