import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");

            for (int j = 0; j < split.length; j++) {
                sb.append(new StringBuffer(split[j]).reverse()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}