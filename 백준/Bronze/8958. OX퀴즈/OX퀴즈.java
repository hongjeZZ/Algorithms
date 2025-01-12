import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            int answer = 0;
            int cnt = 0;

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (c == 'O') {
                    cnt++;
                    answer += cnt;
                } else {
                    cnt = 0;
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}