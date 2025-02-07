import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();

        int MAX_SIZE = 10000;
        int current = Math.min(MAX_SIZE, Integer.parseInt(st.nextToken()));
        int max = current;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            current -= out;

            int in = Integer.parseInt(st.nextToken());
            current = Math.min(current + in, MAX_SIZE);

            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
