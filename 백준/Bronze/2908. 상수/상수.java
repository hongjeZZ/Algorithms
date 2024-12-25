import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] numbers = br.readLine().split(" ");
        String num1 = new StringBuilder(numbers[0]).reverse().toString();
        String num2 = new StringBuilder(numbers[1]).reverse().toString();

        // 뒤집힌 숫자 비교
        int reversedNum1 = Integer.parseInt(num1);
        int reversedNum2 = Integer.parseInt(num2);

        // 더 큰 수 출력
        System.out.println(Math.max(reversedNum1, reversedNum2));
    }
}