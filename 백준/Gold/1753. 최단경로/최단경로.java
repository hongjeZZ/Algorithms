import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Node>> list = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // List 초기화
        for (int i = 0; i < V + 1; i++) {
            list.add(new ArrayList<>());
        }

        // 노드, 간선, 비용 저장
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
        }

        // 최단 거리 저장 배열
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // start 노드는 비용이 0
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            // 새로운 노드를 꺼냄
            Node node = pq.poll();
            int idx = node.idx;
            int cost = node.cost;  // 현재 idx 노드까지의 비용

            // 이미 방문한 노드라면 즉시 종료
            // 현재 idx 노드까지의 비용이
            // idx 노드까지의 최소 비용보다 크다면 "이미 방문한 노드임"
            // 왜냐면 distance[] 배열은 Integer.MAX_VALUE 로 초기화되었기 때문에
            // 최소 비용 or Max 가 들어가게됨
            // cost > distance[idx] 라는 의미는 현재 node 가 우선순위에 밀려 나온 값이라는 것
            if (cost > distance[idx]) {
                continue;
            }

            // 인접한 노드의 거리 계산
            for (Node next : list.get(idx)) {
                // 새로운 비용
                int newCost = cost + next.cost;

                // 새로운 비용이 더 저렴하다면 교체 및 우선순위 큐에 담기
                if (newCost < distance[next.idx]) {
                    distance[next.idx] = newCost;
                    pq.offer(new Node(next.idx, newCost));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            int append = distance[i];

            if (append == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(append).append("\n");
        }

        System.out.println(sb);
    }
}