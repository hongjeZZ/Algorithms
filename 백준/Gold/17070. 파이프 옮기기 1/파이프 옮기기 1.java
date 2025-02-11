import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pipe {
        int x;
        int y;
        int direction; // 0 가로, 1 세로, 2 대각선

        public Pipe(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

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

        bfs();
        System.out.println(cnt);
    }

    public static void bfs() {
        Queue<Pipe> q = new LinkedList<>();
        q.offer(new Pipe(0, 1, 0));

        while (!q.isEmpty()) {
            Pipe pipe = q.poll();
            int x = pipe.x;
            int y = pipe.y;
            int direction = pipe.direction;

            // 도착하면 종료
            if (x == N - 1 && y == N - 1) {
                cnt++;
                continue;
            }

            // 우측으로 이동이 가능하다면
            if (direction != 1 && canMove(x, y + 1)) {
                q.offer(new Pipe(x, y + 1, 0));
            }
            // 하단으로 이동이 가능하다면
            if (direction != 0 && canMove(x + 1, y)) {
                q.offer(new Pipe(x + 1, y, 1));
            }
            // 우측 대각으로 이동이 가능하다면
            if (canMove(x, y + 1) && canMove(x + 1, y) && canMove(x + 1, y + 1)) {
                q.offer(new Pipe(x + 1, y + 1, 2));
            }
        }
    }

    public static boolean canMove(int x, int y) {
        return x < N && y < N && arr[x][y] != 1;
    }
}