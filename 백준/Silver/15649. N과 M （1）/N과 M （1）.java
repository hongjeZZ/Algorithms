import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;
    static int N;
    static int M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        combination(new ArrayList<>(), 0);
        System.out.println(sb);
    }

    public static void combination(List<Integer> selected, int depth) {
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
                selected.add(i);
                combination(selected, depth + 1);
                visited[i] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }
}