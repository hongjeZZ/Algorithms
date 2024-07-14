import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringTokenizer st;
        
        int a, b;
        int size = Integer.parseInt(br.readLine());

        for (int i = 1; i <= size; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.printf("Case #%d: %d\n", i, a + b);
        }
        br.close();
    }
}