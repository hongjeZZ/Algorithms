import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];

        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int value = rope[i] * (N - i);

            if (value > max) max = value;
        }

        System.out.println(max);
    }
}