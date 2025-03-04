import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = map.getOrDefault(c, -1);
            
            if (idx == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - idx;
            }
            map.put(c, i);
        }
        
        return answer;
    }
}