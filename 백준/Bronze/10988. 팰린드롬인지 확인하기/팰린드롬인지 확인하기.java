import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int answer = 0;

        if (line.length() % 2 == 0) {
            String a = line.substring(0, line.length() / 2);
            String b = line.substring(line.length() / 2);
            
            if (a.contentEquals(new StringBuffer(b).reverse())) {
                answer = 1;
            }
            System.out.println(answer);
            
        } else {
            String a = line.substring(0, line.length() / 2);
            String b = line.substring(line.length() / 2 + 1);

            if (a.contentEquals(new StringBuffer(b).reverse())) {
                answer = 1;
            }
            System.out.println(answer);
        }
    }
}