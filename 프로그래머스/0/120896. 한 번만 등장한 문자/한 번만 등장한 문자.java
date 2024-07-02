import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public String solution(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.merge(ch, 1, Integer::sum);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1) {
                answer.append(ch);
            }
        }
        char[] charArray = answer.toString().toCharArray();
        Arrays.sort(charArray);
        
        return new String(charArray);
    }
}