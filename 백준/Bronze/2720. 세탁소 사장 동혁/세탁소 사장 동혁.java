import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] coinArr = new int[]{25, 10, 5, 1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int change = Integer.parseInt(br.readLine());

            for (int value : coinArr) {
                int coinCnt = change / value;
                change -= value * coinCnt;
                sb.append(coinCnt);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}