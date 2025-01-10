import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        int one = 0;
        int zero = 0;
        char prev = '\0';

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                if (prev != '0') {
                    zero++;
                }
            }
            if (input.charAt(i) == '1') {
                if (prev != '1') {
                    one++;
                }
            }
            prev = input.charAt(i);
        }

        System.out.println(Math.min(one, zero));
    }
}