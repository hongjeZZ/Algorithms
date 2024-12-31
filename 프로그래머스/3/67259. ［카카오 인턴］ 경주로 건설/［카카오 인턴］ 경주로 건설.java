import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    int N;
    int[][][] cost;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] board) {
        N = board.length;
        cost = new int[N][N][4];

        // 최대 금액 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        // 시작점 초기화
        for (int i = 0; i < 4; i++) {
            cost[0][0][i] = 0; // 모든 방향에서 시작점 비용을 0으로 설정
        }

        return bfs(board);
    }

    public int bfs(int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 행, 열, 방향, 비용
        q.offer(new int[]{0, 0, -1, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int d = poll[2];
            int nowCost = poll[3];

            if (x == N - 1 && y == N - 1) {
                pq.add(nowCost);
            }

            for (int i = 0; i < 4; i++) { // 동, 서, 북, 남 방향 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];
                int newCost;

                // board 를 벗어나거나, 벽이 있다면 즉시 종료
                if (nx >= N || ny >= N || nx < 0 || ny < 0 || board[nx][ny] == 1) {
                    continue;
                }

                // 금액 계산
                // 방향이 같거나, 처음 시작하는 경우라면 100원 추가
                if (d == i || d == -1) {
                    newCost = nowCost + 100;
                }
                // 그게 아니라면, 100 + 500 = 600원 추가
                else {
                    newCost = nowCost + 600;
                }

                // cost[][] 의 값과 비교하여 더 금액이 같거나 낮게 든다면 실행
                if (cost[nx][ny][i] >= newCost) {
                    q.offer(new int[]{nx, ny, i, newCost});
                    cost[nx][ny][i] = newCost;
                }
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0}
        };

        Solution solution = new Solution();
        System.out.println(solution.solution(matrix));
    }
}