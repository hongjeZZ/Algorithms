import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int N;
    int M;
    int[] start;
    int[] lever;
    int[] exit;
    int[][] distance;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();

        // 위치 정보 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'E') {
                    exit = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }

        // 레버를 당기러 가는 최단 경로 구하기
        int bfsLever = bfs(start, lever, maps);

        if (bfsLever == -1) {
            return -1;
        }
        answer += bfsLever;

        // 레버를 당긴 위치에서 출입구로 나가는 최단 경로 구하기
        int bfsExit = bfs(lever, exit, maps);

        if (bfsExit == -1) {
            return -1;
        }
        answer += bfsExit;
        return answer;
    }

    public int bfs(int[] idx, int[] destination, String[] maps) {
        // 변수 초기화
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        distance = new int[N][M];
        distance[idx[0]][idx[1]] = 0;

        // 방문 처리
        visited[idx[0]][idx[1]] = true;
        q.offer(idx);

        // 큐의 요소가 남지 않을 때까지 반복
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            if (x == destination[0] && y == destination[1]) {
                return distance[x][y];
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로의 범위에서 벗어나면 종료
                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }

                // 벽이 아니고, 방문하지 않았으면 방문 처리
                if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    // 방문 처리
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    distance[nx][ny] += distance[x][y] + 1;
                }
            }
        }
        return -1;
    }
}