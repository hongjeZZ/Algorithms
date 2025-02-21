import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String boom = br.readLine();
        int boomLen = boom.length();

        StringBuilder sb = new StringBuilder();

        for (char ch : line.toCharArray()) {
            sb.append(ch);
            
            if (sb.length() >= boomLen && sb.substring(sb.length() - boomLen).equals(boom)) {
                sb.delete(sb.length() - boomLen, sb.length());
            }
        }

        // 결과 출력
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}