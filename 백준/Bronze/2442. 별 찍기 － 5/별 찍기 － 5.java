import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            sb.append(" ".repeat(size - (i + 1)));
            sb.append("*".repeat(2 * i + 1));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}