import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, S, X, Y;
    static int[][] lab;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<Virus> q = new LinkedList<>();
    static List<Virus> list = new ArrayList<>();

    static class Virus {
        int x;
        int y;
        int number;

        public Virus(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        lab = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if (lab[i][j] != 0) {
                    list.add(new Virus(i, j, lab[i][j]));
                }
            }
        }

        list.sort(Comparator.comparingInt(v -> v.number));
        q.addAll(list);

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        bfs();
        System.out.println(lab[X][Y]);
    }

    public static void bfs() {
        int time = 0;

        while (!q.isEmpty()) {
            // 시간이 S가 되면 종료
            if (time == S) return;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Virus virus = q.poll();
                int x = virus.x;
                int y = virus.y;
                int number = virus.number;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= N || ny >= N || nx < 0 || ny < 0) {
                        continue;
                    }

                    if (lab[nx][ny] == 0) {
                        q.offer(new Virus(nx, ny, number));
                        lab[nx][ny] = number;

                        if (nx == X && ny == Y) return;
                    }
                }
            }
            if (!q.isEmpty()) {
                time++;
            }
        }
    }
}