import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int sum = 0;
        int[] counting = new int[8000 + 1];
        int maxFreq = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[i] = value;
            counting[arr[i] + 4000]++;
            maxFreq = Math.max(maxFreq, counting[arr[i] + 4000]);
        }

        Arrays.sort(arr);

        List<Integer> modes = new ArrayList<>();
        for (int i = 0; i < counting.length; i++) {
            if (counting[i] == maxFreq) {
                modes.add(i - 4000);
            }
        }
        int mode = (modes.size() > 1) ? modes.get(1) : modes.get(0);

        System.out.println(Math.round(sum / (double) N)); // 평균 (반올림)
        System.out.println(arr[N / 2]); // 중앙값
        System.out.println(mode); // 최빈값
        System.out.println(N == 1 ? 0 : arr[N - 1] - arr[0]); // 범위
    }
}