import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                sb.append("1 0\n");
                continue;
            } else if (N == 1) {
                sb.append("0 1\n");
                continue;
            }

            // DP 테이블 생성
            int[][] d = new int[N + 1][2];

            d[0][0] = 1;
            d[0][1] = 0;
            d[1][0] = 0;
            d[1][1] = 1;

            for (int j = 2; j < N + 1; j++) {
                d[j][0] = d[j - 1][0] + d[j - 2][0];
                d[j][1] = d[j - 1][1] + d[j - 2][1];
            }

            sb.append(d[N][0]).append(" ").append(d[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}