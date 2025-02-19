import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        int index = 0;
        while (index < line.length()) {
            char c = line.charAt(index);

            // 태그 처리
            if (c == '<') {
                while (index < line.length() && line.charAt(index) != '>') {
                    sb.append(line.charAt(index));
                    index++;
                }
                sb.append('>'); // '>' 추가
                index++;
            }

            // 단어 뒤집기
            else if (Character.isLetterOrDigit(c)) {
                int start = index;
                while (index < line.length() && Character.isLetterOrDigit(line.charAt(index))) {
                    index++;
                }
                sb.append(new StringBuilder(line.substring(start, index)).reverse());
            }

            // 공백은 그대로 추가
            else {
                sb.append(c);
                index++;
            }
        }
        System.out.println(sb);
    }
}