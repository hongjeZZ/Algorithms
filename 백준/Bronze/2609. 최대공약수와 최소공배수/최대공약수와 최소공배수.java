import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(getGCD(a, b));
        System.out.println(getLCM(a, b, getGCD(a, b)));
    }

    // 최대 공약수
    public static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소 공배수
    public static int getLCM(int a, int b, int gcd) {
        return (a / gcd) * b;
    }
}