import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        combination(new ArrayList<>(), 1, 0);
        System.out.println(sb);
    }

    public static void combination(List<Integer> selected, int start, int depth) {
        if (depth == M) {
            for (int value : selected) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N + 1; i++) {
            selected.add(i);
            combination(selected, i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }
}