import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1\n");
                continue;
            }

            // 각 알파벳별 등장 인덱스 저장
            List<Integer>[] positions = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                positions[i] = new ArrayList<>();
            }

            // 문자열에서 각 문자 위치 저장
            for (int i = 0; i < line.length(); i++) {
                positions[line.charAt(i) - 'a'].add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // 각 알파벳별로 확인
            for (int i = 0; i < 26; i++) {
                if (positions[i].size() < K) continue;

                List<Integer> list = positions[i];

                for (int j = 0; j <= list.size() - K; j++) {
                    int length = list.get(j + K - 1) - list.get(j) + 1;
                    min = Math.min(min, length);
                    max = Math.max(max, length);
                }
            }

            if (min == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }
        System.out.println(sb);
    }
}