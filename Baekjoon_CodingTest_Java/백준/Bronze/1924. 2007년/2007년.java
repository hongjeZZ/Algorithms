import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input_mon = scanner.nextInt();
        int input_day = scanner.nextInt();

        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sum = 0;

        for (int i = 1; i < input_mon; i++) {
            sum += day[i-1];
        }
        sum += input_day;
        System.out.println(days[sum % 7]);
    }
}