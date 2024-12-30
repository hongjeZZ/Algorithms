import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            list.get(X).add(Y);
            list.get(Y).add(X);
        }

        int count = 0;
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            count += bfs(i);
        }

        System.out.println(count);
    }

    static int bfs(int idx) {
        if (visited[idx]) {
            return 0;
        }

        visited[idx] = true;
        queue.offer(idx);

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 0; i < list.get(x).size(); i++) {
                Integer y = list.get(x).get(i);
                if (!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                }
            }
        }
        return 1;
    }
}