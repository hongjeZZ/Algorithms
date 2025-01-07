import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;
        int cost;
        int wall;

        public Node(int x, int y, int cost, int wall) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        int[][] map = new int[N][M];
        int[][][] distance = new int[N][M][2];

        // 최소 거리 저장 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }
        }

        // map 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));
        distance[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            if (x == N - 1 && y == M - 1) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int cost = node.cost + 1;

                // 범위를 벗어난 경우
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }

                int wall = map[nx][ny] + node.wall;

                if (wall <= 1 && cost < distance[nx][ny][wall]) {
                    // 최소 비용 갱신
                    distance[nx][ny][wall] = cost;
                    q.offer(new Node(nx, ny, cost, map[nx][ny] + node.wall));
                }
            }
        }

        // 두 경우 모두 된다면 가장 큰 값 출력
        if (distance[N - 1][M - 1][0] == Integer.MAX_VALUE && distance[N - 1][M - 1][1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(distance[N - 1][M - 1][0], distance[N - 1][M - 1][1]));
        }
    }
}