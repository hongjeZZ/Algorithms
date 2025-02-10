import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            dfs(i, i);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }

    public static void dfs(long num, int lastDigit) {
        list.add(num);

        for (int i = 0; i < lastDigit; i++) {
            dfs(num * 10 + i, i);
        }
    }
}