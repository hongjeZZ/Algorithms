import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] student = new int[N];

            for (int j = 0; j < N; j++) {
                student[j] = Integer.parseInt(st.nextToken());
                sum += student[j];
            }
            double average = (double) sum / N;

            int goodStudent = 0;
            for (int j = 0; j < N; j++) {
                if (student[j] > average) {
                    goodStudent++;
                }
            }

            double per = ((double) goodStudent / N) * 100;
            sb.append(String.format("%.3f", per)).append("%\n");
        }
        System.out.println(sb);
    }
}