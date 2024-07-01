class Solution {
    public int[][] solution(int[] num_list, int n) {
        int rows = num_list.length / n;
        int cols = n;
        
        int[][] answer = new int[rows][n];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                answer[i][j] = num_list[(i * n) + j];
            }
        }
        return answer;
    }
}