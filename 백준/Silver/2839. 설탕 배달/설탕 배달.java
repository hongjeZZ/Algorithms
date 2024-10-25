import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 4,7 이 아니면 모든 경우 봉투에 담을 수 있음
        if (N == 4 || N == 7) {
            System.out.println(-1);
        }

        // 5로 나누어 떨어지는 경우
        else if (N % 5 == 0) {
            System.out.println(N / 5);
        }

        // 6, 8, 11, 13... 의 경우 아래 2가지 경우의 수로 구할 수 있음
        // 5kg((N / 5) - 1) + 3kg(2) 개
        // 5kg((N / 5)) + 3kg(1) 개
        else if (N % 5 == 1 || N % 5 == 3) {
            System.out.println((N / 5) + 1);
        }

        // 9, 12, 14, 17... 의 경우 아래 2가지 경우의 수로 구할 수 있음
        // 5kg((N / 5) - 1) + 3kg(3) 개
        // 5kg((N / 5) - 2) + 3kg(4) 개
        else if (N % 5 == 2 || N % 5 == 4) {
            System.out.println((N / 5) + 2);
        }
    }
}