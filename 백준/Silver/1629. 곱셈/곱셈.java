import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(powMod(A, B, C));
    }

    public static long powMod(long a, long b, long c) {
        if (b == 0) return 1;  //
        long half = powMod(a, b / 2, c);
        long result = (half * half) % c;

        if (b % 2 == 1) result = (result * a) % c;
        return result;
    }
}