import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k;
    static int[] min;
    static int max = 100000;

    public static class Node implements Comparable<Node> {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        min = new int[max + 1];
        Arrays.fill(min, Integer.MAX_VALUE);

        if (n >= k) {
            System.out.println(n - k);
        } else {
            bfs();
            System.out.println(min[k]);
        }
    }

    public static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(n, 0));
        min[n] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int idx = node.x;
            int time = node.time;

            // 이미 방문한 노드라면 종료
            if (min[idx] < time) {
                continue;
            }

            if (idx + 1 <= max && min[idx + 1] > time + 1) {
                q.offer(new Node(idx + 1, time + 1));
                min[idx + 1] = time + 1;
            }
            if (idx - 1 >= 0 && min[idx - 1] > time + 1) {
                q.offer(new Node(idx - 1, time + 1));
                min[idx - 1] = time + 1;
            }
            if (idx * 2 <= max && min[idx * 2] > time) {
                q.offer(new Node(idx * 2, time));
                min[idx * 2] = time;
            }
        }
    }
}