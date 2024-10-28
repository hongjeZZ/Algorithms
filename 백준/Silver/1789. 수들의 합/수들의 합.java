import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        int N = 0;
        int min = 1;

        while (true) {
            // 작은 순서로 원소 삽입
            if (min >= S - min) {
                N++;
                break;
            }

            S -= min;
            N++;
            min++;
        }

        System.out.println(N);
    }
}