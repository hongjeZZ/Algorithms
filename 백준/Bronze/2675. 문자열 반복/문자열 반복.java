import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] inputs = br.readLine().split(" ");
            int num = Integer.parseInt(inputs[0]);

            for (char c : inputs[1].toCharArray()) {
                String str = String.valueOf(c).repeat(num);
                sb.append(str);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}