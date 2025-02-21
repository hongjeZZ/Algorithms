import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 날짜
        int X = Integer.parseInt(st.nextToken()); // 구하고 싶은 기간

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int cnt = 0;
        int value = 0;

        // 초기값 계산
        for (int i = 0; i < X; i++) {
            value += arr[i];
        }
        max = value;
        cnt = 1;

        // 슬라이딩 윈도우 알고리즘
        for (int i = 1; i < N - X + 1; i++) {
            value = value - arr[i - 1] + arr[i + X - 1];

            if (value > max) {
                max = value;
                cnt = 1;
            } else if (value == max) {
                cnt++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}