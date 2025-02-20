import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[61][61][61];
    static int[] attack = {9, 3, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] SCV = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SCV[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블 초기화
        for (int[][] arr2 : dp) {
            for (int[] arr : arr2) {
                Arrays.fill(arr, -1);
            }
        }
        System.out.println(dfs(SCV[0], SCV[1], SCV[2]));
    }

    public static int dfs(int a, int b, int c) {
        if (a <= 0 && b <= 0 && c <= 0) return 0;
        
        a = Math.max(a, 0);
        b = Math.max(b, 0);
        c = Math.max(c, 0);

        // 이미 방문한 경우
        if (dp[a][b][c] != -1) return dp[a][b][c];

        int minValue = Integer.MAX_VALUE;

        // 6가지 공격 조합 수행
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                for (int k = 0; k < 3; k++) {
                    if (i == k || j == k) continue;
                    
                    int dfs = dfs(a - attack[i], b - attack[j], c - attack[k]);
                    minValue = Math.min(minValue, dfs);
                }
            }
        }
        // 최소 공격 횟수 반환
        return dp[a][b][c] = minValue + 1;
    }
}