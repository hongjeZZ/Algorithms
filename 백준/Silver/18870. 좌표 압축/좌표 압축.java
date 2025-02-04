import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] clone = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = clone[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(clone);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for (int i = 0; i < N; i++) {
            if (!map.containsKey(clone[i])) {
                map.put(clone[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}