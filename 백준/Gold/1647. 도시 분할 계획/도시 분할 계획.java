import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static List<Node> list = new ArrayList<>();

    static class Node implements Comparable<Node> {
        int nodeA;
        int nodeB;
        int cost;

        public Node(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        // 노드의 루트 노드를 자신으로 초기화
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(nodeA, nodeB, cost));
        }
        Collections.sort(list);

        int res = 0;
        int max = Integer.MIN_VALUE;

        for (Node node : list) {
            // 싸이클이 생성되지 않는 경우
            if (findParent(node.nodeA) != findParent(node.nodeB)) {
                unionParent(node.nodeA, node.nodeB);
                res += node.cost;
                max = Math.max(node.cost, max);
            }
        }
        System.out.println(res - max);
    }

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = findParent(parent[x]);
        return parent[x];
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a > b) parent[a] = b;
        else parent[b] = a;
    }
}