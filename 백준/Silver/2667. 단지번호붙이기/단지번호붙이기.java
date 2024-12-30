import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> apt = new PriorityQueue<>();
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
                int count = dfs(new int[]{i, j});
                if (count != 0) apt.add(count);
            }
        }

        System.out.println(apt.size());
        while (!apt.isEmpty()) {
            System.out.println(apt.poll());
        }
    }

    static int dfs(int[] idx) {
        int x = idx[0];
        int y = idx[1];

        if (map[x][y] == 0 || visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                count += dfs(new int[]{nx, ny});
            }
        }
        return count;
    }
}