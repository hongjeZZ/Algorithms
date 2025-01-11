import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] commands = br.readLine().toCharArray();
            int dCount = 0;
            for (char c : commands) {
                if (c == 'D') {
                    dCount++;
                }
            }

            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            // 0일 때 예외처리
            if (n == 0) {
                sb.append(dCount != 0 ? "error" : "[]").append("\n");
                continue;
            }

            // 계산 전 예외 처리
            if (dCount > n) {
                sb.append("error").append("\n");
                continue;
            }

            Deque<Integer> queue = new LinkedList<>();
            boolean isReverse = false;
            String[] nums = line.substring(1, line.length() - 1).split(",");

            // 큐 초기화
            for (String num : nums) {
                if (!num.isEmpty()) { // 빈 값 방지
                    queue.offer(Integer.parseInt(num));
                }
            }

            // 명령 실행
            for (char command : commands) {
                if (command == 'R') {
                    isReverse = !isReverse;
                } else if (command == 'D') {
                    if (queue.isEmpty()) {
                        sb.append("error").append("\n");
                        break;
                    }
                    if (isReverse) {
                        queue.removeLast();
                    } else {
                        queue.removeFirst();
                    }
                }
            }

            // 큐 출력
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != 'e') { // "error"가 없으면 출력
                sb.append("[");
                if (isReverse) {
                    // 뒤집힌 큐에서 값을 뒤에서부터 출력
                    StringBuilder temp = new StringBuilder();
                    while (!queue.isEmpty()) {
                        if (temp.length() > 0) temp.append(",");
                        temp.append(queue.removeLast());
                    }
                    sb.append(temp);
                } else {
                    // 큐에서 값을 앞에서부터 출력
                    StringBuilder temp = new StringBuilder();
                    while (!queue.isEmpty()) {
                        if (temp.length() > 0) temp.append(",");
                        temp.append(queue.removeFirst());
                    }
                    sb.append(temp);
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}