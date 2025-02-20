import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int[] SCV;
        int cnt;

        public Node(int[] SCV, int cnt) {
            this.SCV = SCV.clone();
            this.cnt = cnt;
        }
    }

    static int[] attack = {9, 3, 1};
    static boolean[][][] visited = new boolean[61][61][61];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] SCV = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SCV[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(SCV));
    }

    public static int bfs(int[] SCV) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(SCV, 0));
        visited[SCV[0]][SCV[1]][SCV[2]] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int[] scv = node.SCV;
            int cnt = node.cnt;

            // 모든 SCV 체력이 0 이하인 경우 최소 공격 횟수 반환
            if (scv[0] <= 0 && scv[1] <= 0 && scv[2] <= 0) {
                return cnt;
            }

            // 6가지 공격 패턴 수행
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    for (int k = 0; k < 3; k++) {
                        if (i == k || j == k) continue;

                        int[] nextSCV = {
                                Math.max(scv[0] - attack[i], 0),
                                Math.max(scv[1] - attack[j], 0),
                                Math.max(scv[2] - attack[k], 0)
                        };

                        if (!visited[nextSCV[0]][nextSCV[1]][nextSCV[2]]) {
                            visited[nextSCV[0]][nextSCV[1]][nextSCV[2]] = true;
                            q.offer(new Node(nextSCV, cnt + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}