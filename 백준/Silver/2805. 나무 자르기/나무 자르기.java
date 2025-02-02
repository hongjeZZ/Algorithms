import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int max = Integer.MIN_VALUE;


        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
            max = Math.max(max, value);
        }

        int low = 1;
        int high = max;
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (cutTree(mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean cutTree(int h) {
        long sum = 0;

        for (int tree : arr) {
            sum += Math.max(0, tree - h);
        }

        return sum >= M;
    }
}