import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;
    static int N;
    static int K;
    static String[] line;

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

        ArrayList<Integer> selected = new ArrayList<>();
        selected.add(1);
        selected.add('n' - 'a' + 1);
        selected.add('t' - 'a' + 1);
        selected.add('i' - 'a' + 1);
        selected.add('c' - 'a' + 1);

        combination(selected, 1, 5);
        System.out.println(max);
    }

    public static void combination(List<Integer> selected, int start, int depth) {
        if (depth == K) {
            int cnt = 0;
            for (String word : line) {
                boolean flag = true;

                for (char c : word.toCharArray()) {
                    if (!selected.contains(c - 'a' + 1)) {
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
        for (int i = start; i < 27; i++) {
            if (!selected.contains(i)) {
                selected.add(i);
                combination(selected, i + 1, depth + 1);
                selected.remove(selected.size() - 1); // 백트래킹
            }
        }
    }
}