import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String[] s = br.readLine().split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String string : s) {
            if (Integer.parseInt(string) > max) {
                max = Integer.parseInt(string);
            }
            if (Integer.parseInt(string) < min) {
                min = Integer.parseInt(string);
            }
        }
        System.out.println(min + " " + max);
    }
}