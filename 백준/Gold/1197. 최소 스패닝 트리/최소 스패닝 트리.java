import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static List<Node> list;

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        // 노드의 루트 노드를 자신으로 초기화
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }

        list = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(from, to, cost));
        }
        Collections.sort(list);

        int res = 0;
        for (Node node : list) {
            // 싸이클이 생성되지 않는다면, 연결
            if (findParent(node.from) != findParent(node.to)) {
                unionParent(node.from, node.to);
                res += node.cost;
            }
        }

        System.out.println(res);
    }

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA < parentB) parent[parentB] = parentA;
        else parent[parentA] = parentB;
    }
}