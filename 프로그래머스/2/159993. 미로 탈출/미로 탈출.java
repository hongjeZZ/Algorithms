import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int N;
    int M;
    int[] start;
    int[] lever;
    int[] exit;
    boolean[][] visited;
    int[][] distance;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    Queue<int[]> q;

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

        q = new LinkedList<>();
        visited = new boolean[N][M];
        distance = new int[N][M];
        distance[start[0]][start[1]] = 0;

        // 레버를 당기러 가는 최단 경로 구하기
        bfs(start, lever, maps);

        if (!visited[lever[0]][lever[1]]) {
            return -1;
        } else {
            answer += distance[lever[0]][lever[1]];
        }

        // 거리 및 방문 정보 초기화
        q = new LinkedList<>();
        visited = new boolean[N][M];
        distance = new int[N][M];
        distance[lever[0]][lever[1]] = 0;

        // 레버를 당긴 위치에서 출입구로 나가는 최단 경로 구하기
        bfs(lever, exit, maps);

        if (!visited[exit[0]][exit[1]]) {
            return -1;
        } else {
            answer += distance[exit[0]][exit[1]];
        }

        return answer;
    }

    public void bfs(int[] idx, int[] destination, String[] maps) {
        // 방문 처리
        visited[idx[0]][idx[1]] = true;
        q.offer(new int[]{idx[0], idx[1]});

        // 큐의 요소가 남지 않을 때까지 반복
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            if (x == destination[0] && y == destination[1]) {
                break;
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
    }
}