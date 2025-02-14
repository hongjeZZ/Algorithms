import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String security = "wghuvijxpqrstacdebfklmnoyz";

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int[] freq = new int[26];

            for (char c : line.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    freq[c - 'a']++;
                }
            }

            int maxFreq = 0;
            char maxChar = '\0';
            boolean isDuplicate = false;

            for (int j = 0; j < 26; j++) {
                if (freq[j] > maxFreq) {
                    maxFreq = freq[j];
                    maxChar = (char) (j + 'a');
                    isDuplicate = false;
                } else if (freq[j] == maxFreq) {
                    isDuplicate = true;
                }
            }

            System.out.println(isDuplicate ? "?" : security.charAt(security.indexOf(maxChar)));
        }
    }
}