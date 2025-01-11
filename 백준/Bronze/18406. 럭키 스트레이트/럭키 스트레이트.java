import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int left = 0;
        int right = 0;

        for (int i = 0; i < line.length() / 2; i++) {
            left += line.charAt(i) - '0';
        }
        for (int i = line.length() / 2; i < line.length(); i++) {
            right += line.charAt(i) - '0';
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}