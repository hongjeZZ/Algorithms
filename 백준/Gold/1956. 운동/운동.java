import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 마을
        int E = Integer.parseInt(st.nextToken()); // 도로

        int[][] map = new int[V + 1][V + 1];

        for (int i = 1; i < V + 1; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i < V + 1; i++) {
            map[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
        }

        // 플로이드 워셜
        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    if (map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (i != j && map[i][j] != Integer.MAX_VALUE && map[j][i] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, map[i][j] + map[j][i]);
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}