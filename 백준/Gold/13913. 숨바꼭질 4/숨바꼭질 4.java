import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int M = Integer.parseInt(st.nextToken()); // 동생 위치

        if (N == M) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        int[] dp = new int[100_001]; // 이동 시간 저장
        int[] parent = new int[100_001]; // 경로 추적을 위한 부모 노드 저장
        Arrays.fill(dp, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        dp[N] = 0;
        parent[N] = -1;

        while (!q.isEmpty()) {
            int point = q.poll();

            if (point == M) {
                break;
            }

            int[] nextPoints = {point - 1, point + 1, point * 2};
            for (int next : nextPoints) {
                if (next >= 0 && next < 100_001 && dp[next] > dp[point] + 1) {
                    dp[next] = dp[point] + 1;
                    parent[next] = point;
                    q.offer(next);
                }
            }
        }

        // 최단 시간
        sb.append(dp[M]).append("\n");

        // 경로 추적
        List<Integer> path = new ArrayList<>();
        for (int i = M; i != -1; i = parent[i]) {
            path.add(i);
        }
        Collections.reverse(path);

        for (int pos : path) {
            sb.append(pos).append(" ");
        }
        System.out.println(sb);
    }
}