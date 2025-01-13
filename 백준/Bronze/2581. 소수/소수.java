import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int min = -1;
        int sum = 0;

        for (int i = M; i <= N; i++) {
            if (isPrimeNumber(i)) {
                if (min == -1) {
                    min = i;
                }
                sum += i;
            }
        }
        if (min == -1) {
            System.out.println(min);
            return;
        }

        System.out.println(sum);
        System.out.println(min);
    }

    public static boolean isPrimeNumber(int num) {
        if (num == 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i = i + 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}