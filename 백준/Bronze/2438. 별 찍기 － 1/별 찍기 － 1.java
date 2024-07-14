import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            sb.append("*".repeat(i + 1));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}