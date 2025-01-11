public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[10001];

        for (int i = 1; i <= 10000; i++) {
            if (dp[i] == 0) {
                sb.append(i).append("\n");
            }

            int num = i;
            int d = i;

            while (num > 0) {
                d += num % 10;
                num /= 10;
            }

            if (d <= 10000) {
                dp[d]++;
            }
        }
        System.out.println(sb);
    }
}