import java.io.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Character> vowel = List.of('a', 'e', 'i', 'o', 'u');

        while (true) {
            String line = br.readLine();

            if (line.equals("end")) {
                break;
            }

            int vowelCnt = 0;

            for (Character c : line.toCharArray()) {
                if (vowel.contains(c)) {
                    vowelCnt++;
                }
            }

            if (vowelCnt == 0) {
                sb.append("<" + line + "> is not acceptable.").append("\n");
                continue;
            }

            vowelCnt = 0;
            int consonantCnt = 0;
            char lastChar = '\0';
            boolean isAcceptable = true;

            for (Character c : line.toCharArray()) {
                if (vowel.contains(c)) {
                    consonantCnt = 0;
                    vowelCnt++;
                } else {
                    vowelCnt = 0;
                    consonantCnt++;
                }

                if ((vowelCnt >= 3 || consonantCnt >= 3) || (lastChar == c) && (c != 'e' && c != 'o')) {
                    isAcceptable = false;
                    break;
                }
                lastChar = c;
            }

            if (isAcceptable) {
                sb.append("<" + line + "> is acceptable.").append("\n");
            } else {
                sb.append("<" + line + "> is not acceptable.").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}