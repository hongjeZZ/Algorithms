import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();

        if (min >= 45) {
            System.out.print(hour + " " + (min - 45));
        } else {
            if (hour != 0) {
                System.out.print((hour - 1) + " " + (min + 15));
            } else {
                System.out.print(23 + " " + (min + 15));
            }
        }
    }
}