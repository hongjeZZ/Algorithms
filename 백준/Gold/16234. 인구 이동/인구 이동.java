import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int L;
    static int R;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) isMoved = true;
                    }
                }
            }

            if (isMoved) {
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }

    public static boolean bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        int sum = arr[i][j];
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 방문 범위를 벗어난다면 종료
                if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                    continue;
                }

                int value = Math.abs(arr[x][y] - arr[nx][ny]);
                if (value >= L && value <= R && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                    sum += arr[nx][ny];
                }
            }
        }

        // 자기 자신밖에 없을 때
        if (list.size() == 1) {
            return false;
        } else {
            int average = sum / list.size();

            for (int[] pos: list) {
                int x = pos[0];
                int y = pos[1];
                arr[x][y] = average;
            }
            return true;
        }
    }
}