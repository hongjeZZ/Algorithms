import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int n, k;
    static boolean[] visited;
    static int max = 100000;
    
    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[max + 1];
        
        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        // 시작 노드 삽입
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;

            if (node.x == k) {
                min = Math.min(min, node.time);
            }

            // X * 2 가 최대값(10만)을 넘기지 않고, 방문하지 않은 경우
            if (node.x * 2 <= max && !visited[node.x * 2]) {
                q.offer(new Node(node.x * 2, node.time));
            }
            // X + 1 가 최대값(10만)을 넘기지 않고, 방문하지 않은 경우
            if (node.x + 1 <= max && !visited[node.x + 1]) {
                q.offer(new Node(node.x + 1, node.time + 1));
            }
            // X - 1 가 0보다 아래이지 않고, 방문하지 않은 경우
            if (node.x - 1 >= 0 && !visited[node.x - 1]) {
                q.offer(new Node(node.x - 1, node.time + 1));
            }
        }
    }
}
