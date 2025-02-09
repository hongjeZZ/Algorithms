import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, total = 0, length = Integer.MAX_VALUE;

        while (end < N) {
            // total 이 목표값(S)보다 커질 때까지 end 인덱스 증가
            total += arr[end++];

            // total 이 목표값(S)보다 커졌다면
            while (total >= S) {
                // 최소 길이 업데이트
                length = Math.min(length, end - start);
                total -= arr[start++];
            }
        }

        System.out.println(length == Integer.MAX_VALUE ? 0 : length);
    }
}