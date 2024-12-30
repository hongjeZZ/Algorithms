import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int count = -1;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] infected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());   // 컴퓨터의 개수
        int M = Integer.parseInt(br.readLine());   // 네트워크의 개수

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        infected = new boolean[N + 1];
        dfs(1);
        System.out.println(count);
    }

    static void dfs(int idx) {
        infected[idx] = true;
        count++;

        for (int i = 0; i < list.get(idx).size(); i++) {
            Integer y = list.get(idx).get(i);
            if (!infected[y]) {
                dfs(y);
            }
        }
    }
}