import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] RCD = br.readLine().split(" ");
        int R = Integer.parseInt(RCD[0]);
        int C = Integer.parseInt(RCD[1]);
        int D = Integer.parseInt(RCD[2]); // 0 -> 북, 1 -> 동, 2 -> 남, 3 -> 서

        Map<Integer, int[]> direction = new HashMap<>();
        direction.put(0, new int[]{-1, 0});  // 북
        direction.put(1, new int[]{0, 1});  // 동
        direction.put(2, new int[]{1, 0}); // 남
        direction.put(3, new int[]{0, -1}); // 서

        int[][] room = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] roomStatus = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(roomStatus[j]);
            }
        }

        int cnt = 0;

        while (true) {
            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (room[R][C] == 0) {
                room[R][C] = 2;
                cnt++;
            }

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (room[R - 1][C] != 0 && room[R + 1][C] != 0 && room[R][C + 1] != 0 && room[R][C - 1] != 0) {
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                int[] directions = direction.get(D);
                R -= directions[0];
                C -= directions[1];

                // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if (room[R][C] == 1) {
                    break;
                }
                // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            } else {
                // 반시계 방향으로 90도 회전한다.
                D = D != 0 ? D - 1 : 3;
                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                int[] directions = direction.get(D);
                if (room[R + directions[0]][C + directions[1]] == 0) {
                    R += directions[0];
                    C += directions[1];
                }
            }
        }
        System.out.println(cnt);
    }
}