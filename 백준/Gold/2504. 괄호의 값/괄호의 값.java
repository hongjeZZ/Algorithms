import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(calculateBracketValue(line));
    }

    public static int calculateBracketValue(String line) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(') {
                stack.push(c);
                value *= 2;
            } else if (c == '[') {
                stack.push(c);
                value *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return 0;
                if (line.charAt(i - 1) == '(') result += value;
                stack.pop();
                value /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return 0;
                if (line.charAt(i - 1) == '[') result += value;
                stack.pop();
                value /= 3;
            }
        }

        return stack.isEmpty() ? result : 0;
    }
}