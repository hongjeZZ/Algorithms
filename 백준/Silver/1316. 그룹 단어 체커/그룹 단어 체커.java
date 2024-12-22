import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int answer = 0;

        loopOut:
        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();

            for (char c : input.toCharArray()) {
                if (stack.contains(c) && stack.peek() != c) {
                    continue loopOut;
                }
                stack.push(c);
            }
            answer++;
        }
        System.out.println(answer);
    }
}