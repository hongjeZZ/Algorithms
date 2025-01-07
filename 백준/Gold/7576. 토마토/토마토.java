import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = 0;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] box = new int[M][N];
        int ripeCount = 0;
        int blankCount = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                box[i][j] = tomato;

                if (tomato == 1) {
                    ripeCount++;
                    q.offer(new int[]{i, j});
                }

                if (tomato == -1) {
                    blankCount++;
                }
            }
        }

        // 저장될 때부터 토마토가 전부 익은 상태
        if (N * M - blankCount == ripeCount) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int size = q.size();

            // BFS 의 탐색 레벨에 따라 반복
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int x = poll[0];
                int y = poll[1];
                
                // 상하좌우 탐색
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + x;
                    int ny = dy[j] + y;

                    // 범위를 벗어날 경우
                    if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1) {
                        continue;
                    }

                    // 익지 않은 토마토일 경우, 방문 처리
                    if (box[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                        box[nx][ny] = 1;
                        ripeCount++;
                    }
                }
            }
            // BFS 탐색이 한 차례 끝났을 때, 익지 않은 토마토가 있다면 날짜를 더함
            if (!q.isEmpty()) {
                day++;
            }
        }

        // 토마토가 모두 익지는 못하는 상황
        if (N * M - blankCount != ripeCount) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }
}