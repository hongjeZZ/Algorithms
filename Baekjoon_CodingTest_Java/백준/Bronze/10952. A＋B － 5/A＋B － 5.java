import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        String str;
        int a, b = 0;

        while (!(str = bufferedReader.readLine()).equals("0 0")) {

            stringTokenizer = new StringTokenizer(str, " ");
            a = Integer.parseInt(stringTokenizer.nextToken());
            b = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(a + b);
        }
    }
}