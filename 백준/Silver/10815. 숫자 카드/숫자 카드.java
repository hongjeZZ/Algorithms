import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int OFF_SET = 10_000_000;
        int SIZE = 20_000_001;

        int[] arr = new int[SIZE];
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[OFF_SET + value]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            sb.append(arr[OFF_SET + value] != 0 ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }
}