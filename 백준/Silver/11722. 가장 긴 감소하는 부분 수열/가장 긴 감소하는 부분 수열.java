import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 수열 정보 저장
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블 생성
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}