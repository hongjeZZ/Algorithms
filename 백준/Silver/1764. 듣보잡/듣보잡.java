import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        // 듣도 못한 사람 저장
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        Set<String> treeSet = new TreeSet<>();

        for (int i = 0; i < M; i++) {
            String line = br.readLine();

            if (set.contains(line)) {
                treeSet.add(line);
            }
        }

        sb.append(treeSet.size()).append("\n");

        for (String value : treeSet) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}