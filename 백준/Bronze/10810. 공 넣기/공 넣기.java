import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];

        for (int s = 0; s < N; s++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (; i <= j; i++) {
                arr[i - 1] = k;
            }
        }
        
        for (int i = 0; i < M; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }
}