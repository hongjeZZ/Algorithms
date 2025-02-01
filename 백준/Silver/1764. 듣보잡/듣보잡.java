import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        // 듣도 못한 사람 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            map.put(line, map.getOrDefault(line,  0) + 1);
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            Integer value = map.getOrDefault(line, 0);

            if (value != 0) {
                list.add(line);
            }
        }

        sb.append(list.size()).append("\n");

        list.sort(String::compareTo);

        for (String line : list) {
            sb.append(line).append("\n");
        }
        System.out.println(sb);
    }
}