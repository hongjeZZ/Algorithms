import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int cnt = 1;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        if (dp[N] < K) {
            System.out.println(-1);
            return;
        }

        combination(new ArrayList<>(), K, 0, N);
        System.out.println(sb.toString());
    }

    public static void combination(List<Integer> selected, int K, int sum, int N) {
        if (sum == N) {
            if (cnt < K) {
                cnt++;
            } else if(cnt == K) {
                for (int i = 0; i < selected.size(); i++) {
                    sb.append(selected.get(i));

                    if (i + 1 != selected.size()) {
                        sb.append("+");
                    }
                }
                cnt++;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (sum + i <= N) {
                selected.add(i);
                combination(selected, K, sum + i, N);
                selected.remove(selected.size() - 1);
            }
        }
    }
}