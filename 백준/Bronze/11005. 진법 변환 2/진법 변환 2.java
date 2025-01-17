import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(convertToBase(n, b));
    }

    private static String convertToBase(int number, int base) {
        StringBuilder result = new StringBuilder();

        while (number > 0) {
            int remainder = number % base;

            if (remainder < 10) {
                result.append((char) (remainder + '0'));
            } else {
                result.append((char) (remainder - 10 + 'A'));
            }

            number /= base;
        }

        return result.reverse().toString();
    }
}