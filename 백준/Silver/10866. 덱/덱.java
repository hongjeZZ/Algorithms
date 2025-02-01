import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    q.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    q.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(q.isEmpty() ? "-1" : q.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(q.isEmpty() ? "-1" : q.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? "-1" : q.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(q.isEmpty() ? "-1" : q.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}