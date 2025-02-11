import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int direction) {
        if (x == N - 1 && y == N - 1) {
            cnt++;
            return;
        }

        // 우측으로 이동이 가능하다면
        if (direction != 1 && canMove(x, y + 1)) {
            dfs(x, y + 1, 0);
        }
        // 하단으로 이동이 가능하다면
        if (direction != 0 && canMove(x + 1, y)) {
            dfs(x + 1, y, 1);
        }
        // 우측 대각으로 이동이 가능하다면
        if (canMove(x, y + 1) && canMove(x + 1, y) && canMove(x + 1, y + 1)) {
            dfs(x + 1, y + 1, 2);
        }
    }

    public static boolean canMove(int x, int y) {
        return x < N && y < N && arr[x][y] != 1;
    }
}