import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        // 예외 케이스
        if (N <= 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        // 1번을 제외한 각 후보의 득표수를 우선순위 큐에 저장
        for (int i = 0; i < N - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty() && pq.peek() >= target) {
            target++;
            answer++;
            pq.add(pq.poll() - 1);
        }
        System.out.println(answer);
    }
}