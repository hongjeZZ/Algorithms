import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int j = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken());
                arr[j] = x;
            } else {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;

                if (command == 2) {
                    for (int j = l; j <= r; j++) {
                        arr[j] = 1 - arr[j];
                    }
                } else if (command == 3) {
                    for (int j = l; j <= r; j++) {
                        arr[j] = 0;
                    }
                } else {
                    for (int j = l; j <= r; j++) {
                        arr[j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}