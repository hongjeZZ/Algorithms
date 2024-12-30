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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];
        int[][] distance = new int[N][M];
        distance[0][0] = 1;

        // 미로 저장
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(split[j]);
            }
        }

        // 상하좌우 배열 생성
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 위치를 저장할 Queue 선언
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int row = poll[0];
            int col = poll[1];

            if (row == N - 1 && col == M - 1) {
                System.out.println(distance[row][col]);
                break;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                // 방문이 가능할 때
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && room[nx][ny] == 1) {
                    room[nx][ny] = 0;
                    distance[nx][ny] = distance[row][col] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}