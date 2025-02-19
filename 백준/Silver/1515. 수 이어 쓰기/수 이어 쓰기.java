import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int idx = 0;
        int value = 0;

        while (true) {
            value++;
            String valueStr = String.valueOf(value);
            for (int i = 0; i < valueStr.length(); i++) {
                if (valueStr.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
                if (idx == s.length()) {
                    System.out.println(value);
                    return;
                }
            }
        }
    }
}