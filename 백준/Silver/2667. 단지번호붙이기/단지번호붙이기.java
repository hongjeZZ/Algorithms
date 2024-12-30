import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static PriorityQueue<Integer> apt = new PriorityQueue<>();
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());   // 지도의 크기
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(new int[]{i, j});
            }
        }

        System.out.println(apt.size());
        while (!apt.isEmpty()) {
            System.out.println(apt.poll());
        }
    }

    static void bfs(int[] idx) {
        // 집이 아니거나, 이미 체크한 경우 리턴
        if (map[idx[0]][idx[1]] == 0 || visited[idx[0]][idx[1]]) {
            return;
        }
        // 방문 처리
        q.offer(idx);
        int count = 1;
        visited[idx[0]][idx[1]] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        apt.add(count);
    }
}