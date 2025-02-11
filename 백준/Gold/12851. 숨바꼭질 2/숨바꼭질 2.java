import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[100_001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int M = Integer.parseInt(st.nextToken()); // 동생 위치

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0});
        dp[N] = 0;

        int min = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int point = poll[0];
            int time = poll[1];

            if (point == M) {
                min = time;
                cnt++;
            }

            int[] nextPoints = {point - 1, point + 1, point * 2};
            for (int next : nextPoints) {
                if (next >= 0 && next < 100_001 && dp[next] >= time + 1) {
                    dp[next] = time + 1;
                    q.offer(new int[]{next, time + 1});
                }
            }
        }
        System.out.println(min);
        System.out.println(cnt);
    }
}