import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {
            if (isPrimeNumber(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isPrimeNumber(int num) {
        if (num < 2) return false;      // 1은 소수가 아님
        if (num == 2) return true;      // 2는 소수
        if (num % 2 == 0) return false; // 짝수는 소수가 아님

        // 홀수만 체크
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}