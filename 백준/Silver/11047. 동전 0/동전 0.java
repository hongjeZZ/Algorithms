import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        // 코인 정렬 (내림차순)
        int[] coins = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 최소 코인 계산
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (K >= coins[i]) {
                int coinCount = K / coins[i];
                K -= coins[i] * coinCount;
                cnt += coinCount;
            }
        }
        System.out.println(cnt);
    }
}