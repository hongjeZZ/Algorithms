import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] puddleMap = new boolean[n][m];
        for (int[] puddle : puddles) {
            puddleMap[puddle[1] - 1][puddle[0] - 1] = true;
        }
        
        int[] dp = new int[m];
        dp[0] = 1; // 시작점 초기화
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (puddleMap[i][j]) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] = (dp[j] + dp[j - 1]) % 1_000_000_007;
                }
            }
        }
        
        return dp[m - 1];
    }
}