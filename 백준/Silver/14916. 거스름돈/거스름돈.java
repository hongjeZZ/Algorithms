import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = N / 5;
        N %= 5;

        while (cnt >= 0) {
            if (N % 2 == 0) {
                cnt += N / 2;
                System.out.println(cnt);
                return;
            }
            N += 5;
            cnt--;
        }

        System.out.println(-1);
    }
}