import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();

            if (line.equals(".")) {
                break;
            }

            line = line.replaceAll("[^\\[\\]()]", "");

            if (line.isEmpty() || isBalancedString(line)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isBalancedString(String line) {
        Stack<Character> stack = new Stack<>();

        for (char c : line.toCharArray()) {
            // 여는 괄호일 경우
            if (c == '(' || c =='[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() == '[') {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    return false;
                } else if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}