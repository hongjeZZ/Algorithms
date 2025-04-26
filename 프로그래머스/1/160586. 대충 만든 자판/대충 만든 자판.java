import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int pressCount = i + 1;
                map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), pressCount));
            }
        }
        
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPress = 0;
            boolean possible = true;
            
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                if (map.containsKey(c)) {
                    totalPress += map.get(c);
                } else {
                    possible = false;
                    break;
                }
            }
            
            answer[i] = possible ? totalPress : -1;
        }
        
        return answer;
    }
}