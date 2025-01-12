import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            int answer = 0;
            int cnt = 0;

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (c == 'O') {
                    cnt++;
                } else {
                    if (cnt != 0) {
                        while (cnt != 0) {
                            answer += cnt;
                            cnt--;
                        }
                    }
                }
            }
            while (cnt != 0) {
                answer += cnt;
                cnt--;
            }

            System.out.println(answer);
        }
    }
}