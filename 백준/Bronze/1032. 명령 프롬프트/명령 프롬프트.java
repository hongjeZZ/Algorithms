import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }

        String answer = "";

        for (int i = 0; i < names[0].length(); i++) {
            char c = names[0].charAt(i);
            boolean flag = true;

            for (int j = 1; j < names.length; j++) {
                if (names[j].charAt(i) != c) {
                    flag = false;
                    break;
                }
            }

            answer += flag ? c : '?';
        }

        System.out.println(answer);
    }
}