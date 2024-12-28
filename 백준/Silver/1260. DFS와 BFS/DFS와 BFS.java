import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;   // 정점의 갯수
    static int M;   // 간선의 갯수
    static int Y;   // 시작할 정점의 번호
    static boolean[] visited;   // 방문 여부
    static List<List<Integer>> graph = new ArrayList<>();   // BFS 에서 쓰일 Queue
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        // 노드 정보 저장
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        // 그래프의 각 인접 리스트를 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N + 1];
        dfs(Y);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(Y);
        System.out.println(sb);
    }

    // DFS 알고리즘
    public static void dfs(int idx) {
        // 시작 정점 방문 처리
        visited[idx] = true;
        sb.append(idx + " ");

        // 정점과 연결된 노드 순회
        for (int i = 0; i < graph.get(idx).size(); i++) {
            Integer y = graph.get(idx).get(i);

            // 방문하지 않은 노드가 있다면 재귀함수 호출
            if (!visited[y]) {
                dfs(y);
            }
        }
    }

    // BFS 알고리즘
    public static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        // 시작 정점 방문 처리
        visited[idx] = true;
        queue.offer(idx);

        // 큐가 비어있지 않을 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에 저장된 하나의 원소를 뽑아 출력
            Integer x = queue.poll();
            sb.append(x + " ");

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