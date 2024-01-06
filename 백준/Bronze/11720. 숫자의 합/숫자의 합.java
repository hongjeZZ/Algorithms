import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String str = sc.next();

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += str.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}