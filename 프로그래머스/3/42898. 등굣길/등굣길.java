import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1_000_000_007;
        int[][] board = new int[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            visited[puddles[i][1]][puddles[i][0]] = true;
        }

        board[1][1] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (visited[i][j]) {
                    continue;
                }
                board[i][j] += (board[i - 1][j] + board[i][j - 1]) % mod;
            }
        }
        return board[n][m];
    }
}
