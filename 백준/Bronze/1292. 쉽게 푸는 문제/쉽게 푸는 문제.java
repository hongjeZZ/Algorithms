import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[1001];
        int value = 1;
        int idx = 1;

        while (idx < arr.length) {
            for (int i = 0; i < value && idx < arr.length; i++) {
                arr[idx++] = value;
            }
            value++;
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}