import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a != b && b != c && a != c) {
            int max = Math.max(a, Math.max(b, c));

            System.out.println(max * 100);
        } else if (a == b && b == c){ // 3개가 모두 같은 경우
            System.out.println(10000 + a * 1000);
        } else if (a == b || a == c) { // a가 b 혹은 c랑 같은 경우
            System.out.println(1000 + a * 100);
        } else { // b랑 c랑 같은 경우
            System.out.println(1000 + b * 100);
        }
    }
}