import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] lab = new int[N][M];
        int blankCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 1) {
                    blankCount++;
                }
            }
        }

        int answer = 0;

        // 벽을 가두는 모든 경우의 수
        for (int i = 0; i < N * M - 2; i++) {
            // 빈 칸이 아닌 경우
            if (lab[i / M][i % M] > 0) {
                continue;
            }

            for (int j = i + 1; j < N * M - 1; j++) {
                if (lab[j / M][j % M] > 0) {
                    continue;
                }

                for (int k = j + 1; k < N * M; k++) {
                    if (lab[k / M][k % M] > 0) {
                        continue;
                    }
                    // 가벽 세우기
                    int[][] cloneLab = new int[N][M];
                    for (int x = 0; x < N; x++) {
                        cloneLab[x] = lab[x].clone();
                    }
                    cloneLab[i / M][i % M] = 1;
                    cloneLab[j / M][j % M] = 1;
                    cloneLab[k / M][k % M] = 1;

                    visited = new boolean[N][M];
                    int cnt = 0;

                    // BFS 탐색
                    for (int l = 0; l < N; l++) {
                        for (int m = 0; m < M; m++) {
                            if (!visited[l][m] && cloneLab[l][m] == 2) {
                                // { l, m } bfs 탐색으로 점염된 방 수
                                int virus = bfs(new int[]{l, m}, cloneLab);
                                cnt += virus;
                            }
                        }
                    }
                    // 전체 칸 수 - (벽 수 + 감연된 칸 수) = 안전 영역
                    answer = Math.max(answer, (N * M) - (blankCount + 3 + cnt));
                }
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int[] start, int[][] lab) {
        q = new LinkedList<>();

        int cnt = 1;
        q.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }

                if (lab[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}