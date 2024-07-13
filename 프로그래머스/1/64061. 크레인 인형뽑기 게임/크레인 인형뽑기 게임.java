import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] lanes = new Stack[board.length];
        Stack<Integer> bracket = new Stack<>();

        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        for (int move : moves) {
            if (lanes[move-1].isEmpty()) continue;

            if (bracket.isEmpty() || lanes[move-1].peek() != bracket.peek()) {
                bracket.push(lanes[move-1].pop());
            } else {
                lanes[move-1].pop();
                bracket.pop();
                answer += 2;
            }
        }
        return answer;
    }
}