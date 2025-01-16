import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static int X;

    static ArrayList<Integer>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 도시의 개수
        M = Integer.parseInt(st.nextToken());   // 도로의 개수
        K = Integer.parseInt(st.nextToken());   // 최단 거리
        X = Integer.parseInt(st.nextToken());   // 출발 노드

        list = new ArrayList[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        distance[X] = 0;

        while (!q.isEmpty()) {
            int idx = q.poll();

            for (int next : list[idx]) {
                if (distance[next] == -1) {
                    // 최단 거리 갱신
                    distance[next] = distance[idx] + 1;
                    q.offer(next);
                }
            }
        }


        boolean check = false;
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] == K) {
                check = true;
                sb.append(i).append("\n");
            }
        }

        System.out.println(check ? sb : -1);
    }
}