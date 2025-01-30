import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList();

        for (int i = 1; i < N + 1; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            // 제일 위 카드를 바닥에 버린다.
            q.poll();

            // 제일 위 카드를 제일 아래로 옮긴다.
            q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}