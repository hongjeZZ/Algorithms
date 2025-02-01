import java.io.*;
import java.util.*;

public class Main {

    static int[] selected;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        combination(1, 0);
        System.out.println(sb);
    }

    public static void combination(int start, int depth) {
        if (depth == M) {
            for (int value : selected) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N + 1; i++) {
            selected[depth] = i;
            combination(i, depth + 1);
        }
    }
}