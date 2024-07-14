import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int size = sc.nextInt();

        for (int i = 1; i <= size; i++) {
            sb.append(" ".repeat(i - 1));
            sb.append("*".repeat(2 * (size - i) + 1));
            sb.append("\n");
        }
        for (int j = 1; j < size; j++) {
            sb.append(" ".repeat(size - j - 1));
            sb.append("*".repeat(2 * j + 1));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}