import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int N;
    static int M;
    static int start;
    static int end;
    static int[] distance, preN;
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
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        distance = new int[N + 1];      // 노드 별 최소 거리 저장
        preN = new int[N + 1];          // 이전 방문 노드 저장
        list = new List[N + 1];         // 노드 연결, 비용 정보 저장
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(distance[end]);

        // 역추적 시작
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int cnt = 1;

        while (preN[end] != 0) {
            cnt++;
            stack.push(preN[end]);
            end = preN[end];
        }

        System.out.println(cnt);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int idx = node.idx;
            int cost = node.cost;

            if (cost > distance[idx]) {
                continue;
            }

            for (Node next : list[idx]) {
                int nextIdx = next.idx;
                int newCost = cost + next.cost;

                if (distance[nextIdx] > newCost) {
                    distance[nextIdx] = newCost;
                    pq.offer(new Node(nextIdx, newCost));
                    // 이전 방문 노드 추가
                    preN[nextIdx] = idx;
                }
            }
        }
    }
}