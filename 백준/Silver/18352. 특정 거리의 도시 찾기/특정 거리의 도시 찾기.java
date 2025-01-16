import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static int X;

    static ArrayList<Node>[] list;
    static int[] distance;

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 도시의 개수
        M = Integer.parseInt(st.nextToken());   // 도로의 개수
        K = Integer.parseInt(st.nextToken());   // 최단 거리
        X = Integer.parseInt(st.nextToken());   // 출발 노드

        list = new ArrayList[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, 1));
        }

        dijkstra(X);

        boolean check = false;
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] == K) {
                check = true;
                sb.append(i).append("\n");
            }
        }

        System.out.println(check ? sb : -1);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int idx = poll.idx;
            int cost = poll.cost;

            if (distance[idx] < cost) {
                continue;
            }

            for (Node next : list[idx]) {
                int nextIdx = next.idx;
                int nextCost = next.cost + cost;

                if (distance[nextIdx] == -1 || distance[nextIdx] > nextCost) {
                    distance[nextIdx] = nextCost;
                    pq.offer(new Node(nextIdx, nextCost));
                }
            }
        }
    }
}