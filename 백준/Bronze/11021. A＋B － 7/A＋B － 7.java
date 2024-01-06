import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a, b;
        int size = sc.nextInt();

        for (int i = 1; i <= size; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.printf("Case #%d: %d\n", i, a + b);
        }
    }
}