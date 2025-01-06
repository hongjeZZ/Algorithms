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
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // List 초기화
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        // 노드, 간선, 비용 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, cost));
        }

        // 도착지, 목적지 저장
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 최단 거리 저장 배열
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // start 노드는 비용이 0
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            // 새로운 노드를 꺼냄
            Node poll = pq.poll();
            int idx = poll.idx;
            int cost = poll.cost;

            // 이미 방문한 노드라면 즉시 종료
            if (cost > distance[idx]) {
                continue;
            }

            // 인접한 노드의 거리 계산
            for (int i = 0; i < list.get(idx).size(); i++) {
                // 새로운 비용
                int newCost = cost + list.get(idx).get(i).cost;

                // 새로운 비용이 더 저렴하다면 교체 및 우선순위 큐에 담기
                if (newCost < distance[list.get(idx).get(i).idx]) {
                    distance[list.get(idx).get(i).idx] = newCost;
                    pq.offer(new Node(list.get(idx).get(i).idx, newCost));
                }
            }
        }

        System.out.println(distance[end]);
    }
}