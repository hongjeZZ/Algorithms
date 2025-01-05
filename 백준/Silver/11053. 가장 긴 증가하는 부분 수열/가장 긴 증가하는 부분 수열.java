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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블 생성
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int max = 0;
        int answer = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    int result = Math.max(dp[i], dp[j] + 1);
                    dp[i] = result;

                    if (result > max) {
                        max = result;
                        answer = i;
                    }
                }
            }
        }

        System.out.println(dp[answer]);
    }
}