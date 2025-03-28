import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int cnt = 0;

        for (int i = 1; i < N + 1; i++) {
            if (N % i == 0) {
                cnt++;
                
                if (cnt == K) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}