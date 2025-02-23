import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long max = 0;

        if (N % 2 != 0) {
            max = arr[N - 1];
            
            int start = 0;
            int end = N - 2;

            while (start < end) {
                max = Math.max(max, arr[start++] + arr[end--]);
            }
        } else {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                max = Math.max(max, arr[start++] + arr[end--]);
            }
        }
        System.out.println(max);
    }
}