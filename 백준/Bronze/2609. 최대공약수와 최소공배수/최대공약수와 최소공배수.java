import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(getGCD(a, b));
        System.out.println(getLCM(a, b));
    }

    // 최대 공약수
    public static int getGCD(int a, int b) {
        int value = Math.min(a, b);

        while (true) {
            if (a % value == 0 && b % value == 0) {
                break;
            }
            value--;
        }
        return value;
    }

    // 최소 공배수
    public static int getLCM(int a, int b) {
        int value = Math.max(a, b);

        while (true) {
            if (value % a == 0 && value % b == 0) {
                break;
            }
            value++;
        }
        return value;
    }
}