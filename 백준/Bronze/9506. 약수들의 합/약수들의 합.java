import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            int sum = 1;
            StringBuilder divisors = new StringBuilder("1");

            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    divisors.append(" + ").append(i);
                }
            }

            if (sum == n) {
                sb.append(n).append(" = ").append(divisors).append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }
        }

        System.out.print(sb);
    }
}