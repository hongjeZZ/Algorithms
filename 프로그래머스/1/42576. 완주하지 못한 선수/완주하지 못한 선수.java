import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        
        for (String person : completion) {
            map.replace(person, map.get(person) - 1);
        }
        
        for (String person : map.keySet()) {
            if (map.get(person) > 0) {
                return person;
            }
        }
        return "";
    }
}