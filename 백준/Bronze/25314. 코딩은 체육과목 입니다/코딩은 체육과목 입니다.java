import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < (size / 4); i++) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}