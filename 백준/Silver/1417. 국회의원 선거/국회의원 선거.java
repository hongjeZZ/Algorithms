import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        // 예외 케이스
        if (N <= 1) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N - 1];
        int answer = 0;

        // 1번을 제외한 각 후보의 득표수 저장
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (true) {
            // 각 후보들의 최대값과 해당 인덱스 저장
            int idx = -1;
            int max = Integer.MIN_VALUE;

            // 최대값 찾기
            for (int i = 0; i < N - 1; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    idx = i;
                }
            }
            if (target > max) {
                break;
            }
            
            // 1번 득표수를 하나 올리고, 최대 득표자의 득표수를 하나 내림
            target++;
            arr[idx]--;
            answer++;
        }
        System.out.println(answer);
    }
}