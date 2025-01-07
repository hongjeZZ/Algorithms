import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100_001;
    static int[] times = new int[MAX];

    static class Node implements Comparable<Node> {
        int idx;        // 간선의 위치
        int time;       // 현재 간선까지 최소 비용

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(times, Integer.MAX_VALUE);

        // 동생이 수빈이보다 뒤에 위치하는 경우
        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(N, 0));
        times[N] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // 최소 비용보다 큰 경우, 이미 방문한 노드이므로 종료
            if (times[K] < node.time) {
                continue;
            }

            int[] dx = {node.idx - 1, node.idx + 1, node.idx * 2};

            for (int x : dx) {
                int newTime = node.time + 1;

                // 새로운 시간이 최소 시간보다 작다면 방문 처리
                if (x >= 0 && x < MAX && times[x] > newTime) {
                    times[x] = newTime;
                    pq.offer(new Node(x, newTime));
                }
            }
        }

        System.out.println(times[K]);
    }
}