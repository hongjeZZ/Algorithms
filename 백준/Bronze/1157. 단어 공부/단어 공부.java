import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine().toUpperCase();
        int[] charArr = new int[26];
        int max = Integer.MIN_VALUE;
        int count = 0;
        int idx = -1;

        for (char c : input.toCharArray()) {
            charArr[c - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charArr[i] > max) {
                max = charArr[i];
                idx = i;
                count = 1;
            } else if (charArr[i] == max) {
                count++;
            }
        }

        if (count != 1) {
            System.out.println("?");
        } else {
            System.out.println((char) (idx + 'A'));
        }
    }
}