import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 이름의 수
        int M = Integer.parseInt(st.nextToken());   // 노트의 폭

        int[] names = new int[N];
        for (int i = 0; i < N; i++) {
            names[i] = Integer.parseInt(br.readLine());
        }

        // 2차원 DP 테이블 생성
        // dp[N][M] = N번째 이름을 현재 줄에 M개의 글자가 적혔을 때, 남게 되는 칸 수의 제곱의 합
        int[][] dp = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 첫번째 이름 초기화 (마지막 줄은 0)
        dp[0][names[0]] = 0;

        // 이름만큼 반복 (Bottom-Up)
        for (int i = 1; i < N; i++) {
            int next = names[i];
            
            // 이전 이름 탐색 및 DP 테이블 갱신
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j] != Integer.MAX_VALUE) {
                    // 현재 줄에 이름을 계속 쓸 수 있다면 (마지막 줄은 0이니 계산 X, 갱신만)
                    if (j + next + 1 <= M) {
                        dp[i][j + next + 1] = Math.min(dp[i - 1][j], dp[i][j + next + 1]);
                    }
                    // 새로운 줄에 쓰는 경우 (이전 줄의 길이를 계산하여 갱신)
                    dp[i][next] = Math.min(dp[i - 1][j] + (M - j) * (M - j), dp[i][next]);
                }
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            min = Math.min(min, dp[N - 1][i]);
        }
        System.out.println(min);
    }
}