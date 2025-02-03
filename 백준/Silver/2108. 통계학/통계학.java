import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int sum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[i] = value;
            freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(value));
        }

        Arrays.sort(arr);

        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modes.add(entry.getKey());
            }
        }
        Collections.sort(modes);
        int mode = (modes.size() > 1) ? modes.get(1) : modes.get(0);

        System.out.println(Math.round(sum / (double) N)); // 평균 (반올림)
        System.out.println(arr[N / 2]); // 중앙값
        System.out.println(mode); // 최빈값
        System.out.println(N == 1 ? 0 : arr[N - 1] - arr[0]); // 범위
    }
}