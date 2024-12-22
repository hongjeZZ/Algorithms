import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        sb.append("<");

        int idx = 0; // 시작 인덱스
        while (!list.isEmpty()) {
            idx = (idx + K - 1) % list.size();  // K번째 사람을 계산
            sb.append(list.remove(idx));        // 리스트에서 해당 요소 제거 후 추가
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        
        System.out.println(sb);
    }
}