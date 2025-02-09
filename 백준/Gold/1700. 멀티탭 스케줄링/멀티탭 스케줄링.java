import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍 개수
        int K = Integer.parseInt(st.nextToken()); // 전기용품 사용 횟수
        int[] arr = new int[K]; // 전기용품 사용 순서

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> plugged = new ArrayList<>(); // 현재 꽂혀 있는 전기용품
        int cnt = 0;

        for (int i = 0; i < K; i++) {
            int current = arr[i];

            // 이미 꽂혀 있는 경우
            if (plugged.contains(current)) {
                continue;
            }

            // 멀티탭에 빈 공간이 있는 경우
            if (plugged.size() < N) {
                plugged.add(current);
                continue;
            }

            // 전기용품을 교체해야 하는 경우
            int lastUseItem = -1;
            Integer removeTarget = -1;

            for (Integer item : plugged) {
                int nextUse = Integer.MAX_VALUE; // 사용 예정이 없을 경우 방지
                for (int j = i; j < K; j++) {
                    if (arr[j] == item) {
                        nextUse = j;
                        break;
                    }
                }

                if (nextUse > lastUseItem) {
                    lastUseItem = nextUse;
                    removeTarget = item;
                }
            }

            plugged.remove(removeTarget);
            plugged.add(current);
            cnt++;
        }

        System.out.println(cnt);
    }
}