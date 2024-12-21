import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int target = Integer.parseInt(br.readLine()); // 목표
        int num = target;   // 변수
        int answer = 0;     // 사이클

        do {
            int a = num / 10;   // 앞자리
            int b = num % 10;   // 뒷자리

            int sum = a + b;    // 합
            num = b * 10 + sum % 10; // 새로운 수
            answer++;

        } while (target != num);

        System.out.println(answer);
    }
}