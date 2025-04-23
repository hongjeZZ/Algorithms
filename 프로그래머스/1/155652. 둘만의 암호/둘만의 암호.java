import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        List<Character> alphaList = new ArrayList<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            if (!skip.contains(String.valueOf(c))) {
                alphaList.add(c);
            }
        }

        for (char ch : s.toCharArray()) {
            int currentIndex = alphaList.indexOf(ch);
            int newIndex = (currentIndex + index) % alphaList.size();
            answer.append(alphaList.get(newIndex));
        }

        return answer.toString();
    }
}