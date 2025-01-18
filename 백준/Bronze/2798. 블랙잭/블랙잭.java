import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, max = Integer.MIN_VALUE;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0, 0);
        System.out.println(max);
    }

    public static void combination(int start, int depth, int currentSum) {
        if (depth == 3) {
            if (currentSum <= M) {
                max = Math.max(max, currentSum);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            combination(i + 1, depth + 1, currentSum + cards[i]);
        }
    }
}