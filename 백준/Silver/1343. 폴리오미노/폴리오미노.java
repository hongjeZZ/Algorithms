import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        int idx = 0;

        while (idx < line.length()) {
            if (line.charAt(idx) == '.') {
                sb.append('.');
                idx++;
            } else if (line.charAt(idx) == 'X') {
                int start = idx;

                while (true) {
                    idx++;

                    if (idx >= line.length() || line.charAt(idx) != 'X') {
                        break;
                    }
                }

                int length = idx - start;

                // 폴리오미노를 만들 수 없는 경우 종료
                if (length % 2 != 0) {
                    System.out.println(-1);
                    return;
                }

                int aCnt = length / 4;
                length %= 4;
                int bCnt = length / 2;
                sb.append("AAAA".repeat(aCnt));
                sb.append("BB".repeat(bCnt));
            }
        }
        System.out.println(sb);
    }
}