import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] music = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            music[i] = -1;
        }
        music[S] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int volume = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();

            // 모든 볼륨 탐색
            for (int j = 0; j <= M; j++) {
                // 해당 순서의 볼륨 선택
                if (music[j] == (i - 1)) {
                    int plus = j + volume;
                    int minus = j - volume;

                    if (0 <= plus && plus <= M) {
                        list.add(plus);
                    }
                    if (0 <= minus && minus <= M) {
                        list.add(minus);
                    }
                }
            }

            // 볼륨에 따른 순서 업데이트
            for (int j = 0; j < list.size(); j++) {
                music[list.get(j)] = i;
            }
        }
        int max = -1;

        for (int i = 0; i < M + 1; i++) {
            if (music[i] == N) {
                max = Math.max(max, i);
            }
        }
        System.out.println(max);
    }
}