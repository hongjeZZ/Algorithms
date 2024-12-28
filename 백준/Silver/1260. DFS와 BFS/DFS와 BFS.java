import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMY = br.readLine().split(" ");

        // 정점의 갯수
        int N = Integer.parseInt(NMY[0]);
        // 간선의 갯수
        int M = Integer.parseInt(NMY[1]);
        // 시작할 정점의 번호
        int Y = Integer.parseInt(NMY[2]);

        // 노드 정보 저장
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        // 그래프의 각 인접 리스트를 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            graph.get(i).sort(Integer::compareTo);
        }

        boolean[] visited = new boolean[N + 1];
        dfs(graph, Y, visited);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(graph, Y, visited);
    }

    // DFS 알고리즘
    public static void dfs(List<List<Integer>> graph, int Y, boolean[] visited) {
        // 시작 정점 방문 처리
        visited[Y] = true;
        System.out.print(Y + " ");

        // 정점과 연결된 노드 순회
        for (int i = 0; i < graph.get(Y).size(); i++) {
            Integer y = graph.get(Y).get(i);

            // 방문하지 않은 노드가 있다면 재귀함수 호출
            if (!visited[y]) {
                dfs(graph, y, visited);
            }
        }
    }

    // BFS 알고리즘
    public static void bfs(List<List<Integer>> graph, int Y, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        // 시작 정점 방문 처리
        visited[Y] = true;
        queue.offer(Y);

        // 큐가 비어있지 않을 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에 저장된 하나의 원소를 뽑아 출력
            Integer x = queue.poll();
            System.out.print(x + " ");

            // 그 원소에 인접한 노드 중 방문하지 않는 원소들을 큐에 삽입
            for (int i = 0; i < graph.get(x).size(); i++) {
                Integer y = graph.get(x).get(i);
                if (!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                }
            }
        }
    }
}