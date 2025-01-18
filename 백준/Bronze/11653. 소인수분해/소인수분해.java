import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if (N == 1) return;

        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                while (N % i == 0) {
                    sb.append(i).append("\n");
                    N /= i;
                }
            }
        }

        System.out.println(sb);
    }
}