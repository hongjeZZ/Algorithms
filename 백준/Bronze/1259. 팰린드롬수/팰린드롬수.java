import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String value = br.readLine();

            if (value.equals("0")) {
                break;
            }

            boolean flag = true;

            for (int i = 0; i < value.length() / 2; i++) {
                if (value.charAt(i) != value.charAt(value.length() - 1 - i)) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}