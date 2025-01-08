import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(findIntersectionCount(x1, y1, r1, x2, y2, r2)).append("\n");
        }

        System.out.print(sb);
    }

    public static int findIntersectionCount(int x1, int y1, int r1, int x2, int y2, int r2) {
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // 두 원이 동일한 경우 (무한대의 교점)
        if (d == 0 && r1 == r2) {
            return -1;
        }

        // 교점이 없는 경우
        if (d > r1 + r2 || d < Math.abs(r1 - r2)) {
            return 0;
        }

        // 한 점에서 만나는 경우 (외접 또는 내접)
        if (d == r1 + r2 || d == Math.abs(r1 - r2)) {
            return 1;
        }

        // 두 점에서 만나는 경우
        return 2;
    }
}