import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int INF = 200_000_000;
    static int N;
    static int[] distance;
    static List<Node>[] list;

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new List[N + 1];

        if (M == 0) {
            System.out.println(-1);
            return;
        }
        
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        int answer = (result1 > INF && result2 > INF) ? -1 : Math.min(result1, result2);
        System.out.println(answer);
    }

    public static int dijkstra(int start, int end) {
        distance = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            distance[i] = INF;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int idx = node.idx;
            int cost = node.cost;

            if (distance[idx] < cost) {
                continue;
            }

            for (Node next : list[idx]) {
                int nextIdx = next.idx;
                int nextCost = next.cost + cost;

                if (distance[nextIdx] > nextCost) {
                    distance[nextIdx] = nextCost;
                    pq.offer(new Node(nextIdx, nextCost));
                }
            }
        }

        return distance[end];
    }
}