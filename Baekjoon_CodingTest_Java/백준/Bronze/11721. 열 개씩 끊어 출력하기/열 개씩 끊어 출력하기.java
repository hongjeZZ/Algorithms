import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int n = str.length() / 10;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            System.out.println(str.substring(idx, idx + 10));
            idx += 10;
        }
        n = str.length() % 10;
        System.out.println(str.substring(idx, idx + n));
    }
}