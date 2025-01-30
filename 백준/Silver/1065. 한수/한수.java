import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            if (isHanSu(i)) count++;
        }

        System.out.println(count);
    }

    public static boolean isHanSu(int number) {
        if (number < 100) {
            return true;
        }

        int lastDigit = number % 10;
        number /= 10;
        int secondLastDigit = number % 10;
        number /= 10;

        int diff = secondLastDigit - lastDigit; // 등차값 저장

        while (number > 0) {
            int nextDigit = number % 10;
            number /= 10;

            if (nextDigit - secondLastDigit != diff) {
                return false;
            }
            secondLastDigit = nextDigit;
        }
        return true;
    }
}