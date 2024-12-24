import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int time = 0;        // 시작 시간
        int d = 1;           // 동쪽

        // 뱀의 몸통을 저장하는 Deque 생성
        Deque<int[]> deque = new LinkedList<>();
        deque.addFirst(new int[]{0, 0});

        // 빈 곳 -> 0, 사과 -> 1, 뱀의 몸 -> 2
        int[][] room = new int[N][N];
        room[0][0] = 2;

        // 사과 위치 저장
        for (int i = 0; i < K; i++) {
            String[] appleLoc = br.readLine().split(" ");
            int appleX = Integer.parseInt(appleLoc[0]);
            int appleY = Integer.parseInt(appleLoc[1]);
            room[appleX-1][appleY-1] = 1;
        }

        // 뱀의 방향 변환 정보 저장
        int L = Integer.parseInt(br.readLine());

        Map<Integer, String> snakeDirection = new HashMap<>();
        for (int i = 0; i < L; i++) {
            String[] timeAndDir = br.readLine().split(" ");
            int turnTime = Integer.parseInt(timeAndDir[0]);
            snakeDirection.put(turnTime, timeAndDir[1]);
        }

        // 방향 정보 저장 변수
        Map<Integer, int[]> directionMap = new HashMap<>();
        directionMap.put(0, new int[]{-1, 0});     // 북
        directionMap.put(1, new int[]{0, 1});      // 동
        directionMap.put(2, new int[]{1, 0});      // 남
        directionMap.put(3, new int[]{0, -1});     // 서

        while (true) {
            time++;
            int[] directions = directionMap.get(d);
            int[] head = deque.peekFirst();
            int x = head[0] + directions[0];
            int y = head[1] + directions[1];

            // 충돌 확인
            if (x < 0 || x >= N || y < 0 || y >= N || room[x][y] == 2) {
                break;
            } else if (room[x][y] == 1) {
                deque.addFirst(new int[]{x, y});
                room[x][y] = 2;
            } else {
                deque.addFirst(new int[]{x, y});
                room[x][y] = 2;
                int[] tail = deque.pollLast();
                room[tail[0]][tail[1]] = 0;
            }

            // 뱀 방향 전환 정보 확인
            if (snakeDirection.containsKey(time)) {
                String direction = snakeDirection.get(time);
                if (direction.equals("D")) {
                    d = (d + 1) % 4; // 오른쪽
                } else if (direction.equals("L")) {
                    d = (d + 3) % 4; // 왼쪽
                }
            }
        }
        System.out.println(time);
    }
}