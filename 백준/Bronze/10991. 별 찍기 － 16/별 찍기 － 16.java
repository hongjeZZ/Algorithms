import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            sb.append(" ".repeat(size - i - 1));
            for (int j = 0; j < i + 1; j++) {
                sb.append("*");
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}