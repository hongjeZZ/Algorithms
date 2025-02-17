class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] arr = new int[N][N];

        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                arr[i][j] = triangle[i][j];
            }
        }
        
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i - 1][j - 1];
            }
        }

        int max = 0;

        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, dp[N][i]);
        }

        return max;
    }
}