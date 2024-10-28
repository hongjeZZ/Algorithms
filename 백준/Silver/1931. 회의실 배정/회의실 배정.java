import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        // 회의 정보 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
        }

        // 끝나는 시간 기준으로 오름차순 정렬, 끝나는 시간이 같으면 시작 시간 기준으로 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int cnt = 0;
        int end = 0;

        // 회의 선택
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= end) {
                cnt++;
                end = meetings[i][1];
            }
        }

        System.out.println(cnt);
    }
}