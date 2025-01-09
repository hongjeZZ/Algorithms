import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 건물의 수 = N, 건설순서 규칙 수 = K
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] times = new int[N + 1];                           // 노드(건물) 건설 시간
            int[] indegree = new int[N + 1];                        // 노드의 진입 차수 정보를 담는 배열
            int[] dp = new int[N + 1];                              // 간 건물별 시간 계산
            ArrayList<Integer>[] list = new ArrayList[N + 1];       // 노드와 간선의 정보를 담는 인접 리스트

            for (int j = 1; j < N + 1; j++) {
                times[j] = Integer.parseInt(st.nextToken());
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                indegree[to]++;
                list[from].add(to);
            }

            int end = Integer.parseInt(br.readLine());

            // 위상 정렬 시작
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 1; j < N + 1; j++) {
                if (indegree[j] == 0) {
                    queue.offer(j);
                    dp[j] = times[j];
                }
            }

            while (!queue.isEmpty()) {
                int poll = queue.poll();

                for (int next : list[poll]) {
                    indegree[next]--;
                    dp[next] = Math.max(dp[next], dp[poll] + times[next]);

                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            sb.append(dp[end]).append("\n");
        }
        System.out.println(sb);
    }
}