import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            String command = tokenizer.nextToken();

            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}