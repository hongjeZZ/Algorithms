import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            max = Math.max(max, value);
        }

        long low = 1;
        long high = max;
        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (cutCable(mid, arr, M)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean cutCable(long mid, int[] arr, int M) {
        long count = 0;

        for (int value : arr) {
            count += value / mid;

            if (count >= M) {
                return true;
            }
        }

        return false;
    }
}