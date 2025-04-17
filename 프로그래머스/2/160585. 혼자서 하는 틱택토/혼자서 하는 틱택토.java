class Solution {
    public int solution(String[] board) {
        char[][] map = new char[3][3];
        int oCount = 0;
        int xCount = 0;

        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
            for (char c : map[i]) {
                if (c == 'O') oCount++;
                else if (c == 'X') xCount++;
            }
        }

        if (xCount > oCount || oCount - xCount > 1) return 0;

        boolean oWin = isWinner(map, 'O');
        boolean xWin = isWinner(map, 'X');

        if (oWin && xWin) return 0;

        if (oWin && oCount != xCount + 1) return 0;

        if (xWin && oCount != xCount) return 0;

        return 1;
    }

    private boolean isWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++)
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;

        for (int j = 0; j < 3; j++)
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }
}