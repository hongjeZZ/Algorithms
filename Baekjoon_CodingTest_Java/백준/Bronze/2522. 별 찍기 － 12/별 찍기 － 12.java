import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int size = sc.nextInt();

        for (int i = 1; i <= size; i++) {
            sb.append(" ".repeat(size - i));
            sb.append("*".repeat(i));
            sb.append("\n");
        }

        for (int j = 1; j < size; j++) {
            sb.append(" ".repeat(j));
            sb.append("*".repeat(size - j));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}