import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int loveCnt = 0;
        String seat = br.readLine();

        for (char c : seat.toCharArray()) {
            if (c == 'L') loveCnt++;
        }

        int holder = N + 1 - (loveCnt / 2);

        System.out.println(Math.min(holder, N));
    }
}