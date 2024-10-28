import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int change = 1000 - Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5, 1};
        int res = 0;

        for (int coin : coins) {
            if (change >= coin) {
                int cnt = change / coin;
                change -= cnt * coin;
                res += cnt;
            }
        }
        System.out.println(res);
    }
}