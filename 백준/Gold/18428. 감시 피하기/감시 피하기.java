import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[][] arr;
    static List<int[]> teachers = new ArrayList<>();
    static List<int[]> blacks = new ArrayList<>();
    static boolean result = false;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                char c = st.nextToken().charAt(0);
                if (c == 'T') {
                    teachers.add(new int[]{i, j});
                }
                if (c == 'X') {
                    blacks.add(new int[]{i, j});
                }
                arr[i][j] = c;
            }
        }

        combination(new ArrayList<>(), 0, 0);
        System.out.println(result ? "YES" : "NO");
    }

    public static void combination(List<int[]> selected, int start, int depth) {
        if (depth == 3) {
            if (bfs(selected)) result = true;
            return;
        }

        for (int i = start; i < blacks.size(); i++) {
            selected.add(blacks.get(i));
            combination(selected, i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public static boolean bfs(List<int[]> selected) {
        // 복도 복사
        char[][] clone = new char[N][N];
        for (int i = 0; i < arr.length; i++) {
            clone[i] = arr[i].clone();
        }

        // 장애물 설치
        for (int[] ints : selected) {
            clone[ints[0]][ints[1]] = 'O';
        }

        for (int[] teacher : teachers) {
            int x = teacher[0];
            int y = teacher[1];

            // 4 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어나지 않을 때까지 탐색
                while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    // 학생을 만나면 return
                    if (clone[nx][ny] == 'S') {
                        return false;
                    }
                    // 벽 혹은 다른 선생을 만나면 종료
                    if (clone[nx][ny] == 'O' || clone[nx][ny] == 'T') {
                        break;
                    }
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
        return true;
    }
}