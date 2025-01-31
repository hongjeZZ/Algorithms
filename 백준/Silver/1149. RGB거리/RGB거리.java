import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                } else if (j == 1) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                }
            }
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}