import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();

            for (char c : line.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || stack.peek() == ')') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                }
            }

            sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}