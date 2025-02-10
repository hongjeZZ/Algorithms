import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] arr;
    static int N;
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int max = getMaxCount();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }

                    swap(i, j, nx, ny);
                    max = Math.max(getMaxCount(), max);
                    swap(i, j, nx, ny);
                }
            }
        }
        System.out.println(max);
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    public static int getMaxCount() {
        int max = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            int maxCnt = cnt;

            for (int j = 1; j < N; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 1;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
            max = Math.max(max, maxCnt);
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            int maxCnt = cnt;

            for (int j = 1; j < N; j++) {
                if (arr[j][i] == arr[j - 1][i]) {
                    cnt++;
                } else {
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 1;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
            max = Math.max(max, maxCnt);
        }

        return max;
    }
}