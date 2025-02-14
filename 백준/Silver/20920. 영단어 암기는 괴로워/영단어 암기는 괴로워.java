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
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (line.length() < M) continue;
            map.put(line, map.getOrDefault(line, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) return o2.getValue() - o1.getValue();
            if (o1.getKey().length() != o2.getKey().length()) return o2.getKey().length() - o1.getKey().length();
            return o1.getKey().compareTo(o2.getKey());
        });

        pq.addAll(map.entrySet());

        while (!pq.isEmpty()) {
            sb.append(pq.poll().getKey()).append("\n");
        }

        System.out.println(sb);
    }
}