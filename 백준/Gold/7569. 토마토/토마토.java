import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] box = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();

        int totalCount = M * N * H;
        int blankCount = 0;
        int ripeTomatoCount = 0;

        // 박스 상태 저장
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int status = Integer.parseInt(st.nextToken());
                    box[i][j][k] = status;

                    // 익은 토마토의 좌표 저장
                    if (status == 1) {
                        q.offer(new int[]{i, j, k});
                        ripeTomatoCount++;
                    }

                    // 빈칸 개수 저장
                    if (status == -1) {
                        blankCount++;
                    }
                }
            }
        }

        // 저장될 때부터 모든 토마토가 익어있는 상태이면 0 을 출력
        if (totalCount - blankCount == ripeTomatoCount) {
            System.out.println(0);
            return;
        }

        int day = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            // BFS depth 레벨마다 반복
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int z = poll[0];
                int x = poll[1];
                int y = poll[2];

                // 상하좌우밑위 탐색
                for (int j = 0; j < 6; j++) {
                    int nz = z + dz[j];
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    // 박스의 범위를 벗어난다면 즉시 종료
                    if (nz >= H || nx >= N || ny >= M || nz < 0 || nx < 0 || ny < 0) {
                        continue;
                    }

                    // 익지 않은 토마토 칸이라면 실행
                    if (box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = 1;
                        ripeTomatoCount++;
                        q.offer(new int[]{nz, nx, ny});
                    }
                }
            }

            if (!q.isEmpty()) {
                day++;
            }
        }

        // 토마토가 모두 익지는 못하는 상황이면 -1 출력
        if (ripeTomatoCount + blankCount != totalCount) {
            System.out.println(-1);
            return;
        }

        // 모두 익었다면 최소 일수 출력
        System.out.println(day);
    }
}