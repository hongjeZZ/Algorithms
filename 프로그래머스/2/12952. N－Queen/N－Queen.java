class Solution {
    private int count = 0;

    public int solution(int n) {
        int[] board = new int[n]; // board[i]는 i번째 행에 퀸이 놓인 열
        placeQueen(board, 0, n);
        return count;
    }

    private void placeQueen(int[] board, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                placeQueen(board, row + 1, n);
            }
        }
    }

    private boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}