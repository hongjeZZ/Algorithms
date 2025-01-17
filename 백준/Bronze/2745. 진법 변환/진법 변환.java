import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int b = sc.nextInt();

        System.out.println(convertToDecimal(n, b));
    }

    private static long convertToDecimal(String number, int base) {
        long decimalValue = 0;
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char c = number.charAt(i);
            int digitValue;

            if (Character.isDigit(c)) {
                digitValue = c - '0';
            } else {
                digitValue = c - 'A' + 10;
            }
            decimalValue = decimalValue * base + digitValue;
        }
        return decimalValue;
    }
}