import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int wall = Integer.parseInt(st.nextToken());

            for (int j = 0; j < wall; j++) {
                arr[H - 1 - j][i] = 1;
            }
        }

        int cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 벽이라면 종료
                if (arr[i][j] == 1) {
                    continue;
                }

                // 벽이 아니라면, 같은 높이의 벽이 주변에 있는 지 확인
                // 좌측 벽 확인
                int left = j - 1;
                boolean leftFlag = false;

                for (int k = left; k >= 0; k--) {
                    if (arr[i][k] == 1) {
                        leftFlag = true;
                        break;
                    }
                }

                // 우측 벽 확인
                int right = j + 1;
                boolean rightFlag = false;

                for (int k = right; k < W; k++) {
                    if (arr[i][k] == 1) {
                        rightFlag = true;
                        break;
                    }
                }

                if (leftFlag && rightFlag) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}