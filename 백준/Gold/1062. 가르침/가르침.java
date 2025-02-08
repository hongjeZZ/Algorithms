import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;
    static int N;
    static int K;
    static String[] line;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        line = new String[N];

        if (K < 5) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            line[i] = br.readLine();
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        combination(1, 5);
        System.out.println(max);
    }

    public static void combination(int start, int depth) {
        if (depth == K) {
            int cnt = 0;
            for (String word : line) {
                boolean flag = true;

                for (char c : word.toCharArray()) {
                    if (!visited[c - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }

            max = Math.max(max, cnt);
            return;
        }

        // 모든 알파벳 조합
        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}