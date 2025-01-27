import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 수열 정보 저장
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int res = Math.max(dp[i], dp[j] + 1);
                    dp[i] = res;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(N - max);
    }
}