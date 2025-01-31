import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;
    static int N;
    static int M;
    static boolean[] visited;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];
        visited = new boolean[N + 1];

        combination(0);
        System.out.println(sb);
    }

    public static void combination(int depth) {
        if (depth == M) {
            for (int value : selected) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = i;
                combination(depth + 1);
                visited[i] = false;
            }
        }
    }
}