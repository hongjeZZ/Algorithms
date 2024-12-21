import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);

        int[] charCount = new int[26]; // 알파벳 소문자 개수
        for (char c : charArray) {
            charCount[c - 'A']++;
        }

        String palindrome = buildPalindrome(charCount, charArray.length);
        System.out.println(palindrome != null ? palindrome : "I'm Sorry Hansoo");
    }
    private static String buildPalindrome(int[] charCount, int length) {
        StringBuilder half = new StringBuilder();
        char middleChar = 0;
        boolean hasOddMiddle = false;

        for (int i = 0; i < 26; i++) {
            if (charCount[i] % 2 != 0) {
                if (hasOddMiddle) {
                    return null; // 홀수 문자가 두 개 이상이면 팰린드롬 불가능
                }
                hasOddMiddle = true;
                middleChar = (char) (i + 'A');
            }
            // 반쪽 문자열 생성
            for (int j = 0; j < charCount[i] / 2; j++) {
                half.append((char) (i + 'A'));
            }
        }

        return hasOddMiddle ? half.toString() + middleChar + half.reverse() : half.toString() + half.reverse();
    }
}