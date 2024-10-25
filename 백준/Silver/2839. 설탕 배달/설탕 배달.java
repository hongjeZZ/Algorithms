import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (N > 0) {
            // 5로 나누어지면, 몫을 cnt 에 더하여 계산
            if (N % 5 == 0) {
                cnt += N / 5;
                break;
            }
            // 그게 아니라면 3으로 나누어 떨어지거나 계산할 수 없는 것
            cnt++;
            N -= 3;

            if (N < 0) cnt = -1;
        }

        System.out.println(cnt);
    }
}