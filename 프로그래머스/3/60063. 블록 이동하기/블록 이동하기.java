import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Machine {
        Node first;
        Node second;
        int direction; // 가로 0, 세로 1
        int distance;

        public Machine(Node first, Node second, int direction, int distance) {
            this.first = first;
            this.second = second;
            this.direction = direction;
            this.distance = distance;
        }
    }

    static int N;
    static boolean[][][] visited;
    static int[][] arr;
    Queue<Machine> q;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        N = board.length;
        arr = board;
        visited = new boolean[N][N][2];

        q = new LinkedList<>();
        q.offer(new Machine(new Node(0, 0), new Node(0, 1), 0, 0));

        while (!q.isEmpty()) {
            Machine poll = q.poll();
            Node first = poll.first;
            Node second = poll.second;

            int firstX = first.x;
            int firstY = first.y;
            int secondX = second.x;
            int secondY = second.y;
            int direction = poll.direction;
            int distance = poll.distance;

            // 이미 방문했다면 종료
            if (visited[firstX][firstY][direction] && visited[secondX][secondY][direction]) {
                continue;
            }
            // 방문 처리
            visited[firstX][firstY][direction] = true;
            visited[secondX][secondY][direction] = true;

            // 도착한 경우 최단거리 반환
            if (isArrived(first) || isArrived(second)) {
                return distance;
            }

            // 이동 탐색
            for (int i = 0; i < 4; i++) {
                int firstNx = firstX + dx[i];
                int firstNy = firstY + dy[i];
                int secondNx = secondX + dx[i];
                int secondNy = secondY + dy[i];

                // 이동이 불가능하면 종료
                if (isOutOfRange(firstNx, firstNy) || isOutOfRange(secondNx, secondNy)) {
                    continue;
                }

                // 두 Node 중 하나만 방문하지 않았어도 방문처리
                q.offer(new Machine(new Node(firstNx, firstNy), new Node(secondNx, secondNy), direction, distance + 1));
            }

            // 회전 탐색 시작
            // 방향이 가로일 때
            if (direction == 0) {
                // 위로 회전이 가능하다면
                if (!(isOutOfRange(firstX - 1, firstY) || isOutOfRange(secondX - 1, secondY))) {
                    // first 축으로 위로 회전
                    q.offer(new Machine(new Node(firstX, firstY), new Node(firstX - 1, firstY), 1, distance + 1));
                    // second 축으로 위로 회전
                    q.offer(new Machine(new Node(secondX, secondY), new Node(secondX - 1, secondY), 1, distance + 1));
                }
                // 아래로 회전이 가능하다면
                if (!(isOutOfRange(firstX + 1, firstY) || isOutOfRange(secondX + 1, secondY))) {
                    // first 축으로 아래로 회전
                    q.offer(new Machine(new Node(firstX, firstY), new Node(firstX + 1, firstY), 1, distance + 1));
                    // second 축으로 아래로 회전
                    q.offer(new Machine(new Node(secondX, secondY), new Node(secondX + 1, secondY), 1, distance + 1));
                }
            }
            // 방향이 세로일 때
            else {
                // 왼쪽으로 회전이 가능하다면
                if (!(isOutOfRange(firstX, firstY - 1) || isOutOfRange(secondX, secondY - 1))) {
                    // first 축으로 왼쪽 회전
                    q.offer(new Machine(new Node(firstX, firstY), new Node(firstX, firstY - 1), 0, distance + 1));
                    // second 축으로 왼쪽 회전
                    q.offer(new Machine(new Node(secondX, secondY), new Node(secondX, secondY - 1), 0, distance + 1));
                }

                // 오른쪽으로 회전이 가능하다면
                if (!(isOutOfRange(firstX, firstY + 1) || isOutOfRange(secondX, secondY + 1))) {
                    // first 축으로 오른쪽 회전
                    q.offer(new Machine(new Node(firstX, firstY), new Node(firstX, firstY + 1), 0, distance + 1));
                    // second 축으로 오른쪽 회전
                    q.offer(new Machine(new Node(secondX, secondY), new Node(secondX, secondY + 1), 0, distance + 1));
                }
            }
        }
        return -1;
    }

    public boolean isArrived(Node node) {
        int x = node.x;
        int y = node.y;

        return x == N - 1 && y == N - 1;
    }

    public boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x > N - 1 || y > N - 1 || arr[x][y] == 1;
    }
}