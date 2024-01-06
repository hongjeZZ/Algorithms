import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int size = scanner.nextInt();

        for (int i = 1; i <= size; i++) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}