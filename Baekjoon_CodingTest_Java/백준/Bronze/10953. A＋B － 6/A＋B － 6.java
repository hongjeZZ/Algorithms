import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int a, b = 0;
        int size = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < size; i++) {
            str = br.readLine();
            a = Integer.parseInt(str.split(",")[0]);
            b = Integer.parseInt(str.split(",")[1]);
            System.out.println(a + b);
        }
    }
}