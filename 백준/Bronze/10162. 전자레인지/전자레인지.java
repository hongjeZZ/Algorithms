import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int time = Integer.parseInt(br.readLine());
        int[] buttons = {300, 60, 10};
        StringBuilder sb = new StringBuilder();

        if (time % 10 != 0) {
            System.out.println(-1);
            return;
        }

        while (time != 0) {
            for (int button : buttons) {
                int cnt = time / button;
                time -= cnt * button;
                sb.append(cnt);
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}