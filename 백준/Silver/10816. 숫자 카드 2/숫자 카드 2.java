import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int OFFSET = 10_000_000;
        int SIZE = 20_000_001;

        int[] count = new int[SIZE];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            count[value + OFFSET]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            sb.append(count[value + OFFSET]).append(" ");
        }

        System.out.print(sb);
    }
}