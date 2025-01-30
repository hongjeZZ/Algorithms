import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int sum = 0;

        Stack<Integer> q = new Stack<>();

        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number != 0) {
                sum += number;
                q.push(number);
            } else {
                sum -= q.pop();
            }
        }
        System.out.println(sum);
    }
}