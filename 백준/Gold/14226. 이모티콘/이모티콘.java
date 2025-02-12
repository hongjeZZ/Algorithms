import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int target;
    static int minTime = 0;
    static boolean[][] visited;

    static class Node {
        int emogiCount;
        int clipboard;
        int time;

        public Node(int emogiCount, int clipboard, int time) {
            this.emogiCount = emogiCount;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        visited = new boolean[target + 1][target + 1];

        // 초기 상태
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0, 0));
        visited[1][0] = true;

        // bfs 시작
        while (!q.isEmpty()) {
            Node node = q.poll();
            int time = node.time;
            int clipboard = node.clipboard;
            int emogiCount = node.emogiCount;

            // 목표 위치 도달 시 종료
            if (emogiCount == target) {
                minTime = time;
                break;
            }

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (!visited[emogiCount][emogiCount]) {
                q.offer(new Node(emogiCount, emogiCount, time + 1));
                visited[emogiCount][emogiCount] = true;
            }
            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (emogiCount + clipboard <= target && !visited[emogiCount + clipboard][clipboard]) {
                q.offer(new Node(emogiCount + clipboard, clipboard, time + 1));
                visited[emogiCount + clipboard][clipboard] = true;
            }
            // 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (emogiCount - 1 >= 0 && !visited[emogiCount - 1][clipboard]) {
                q.offer(new Node(emogiCount - 1, clipboard, time + 1));
                visited[emogiCount - 1][clipboard] = true;
            }
        }
        System.out.println(minTime);
    }
}