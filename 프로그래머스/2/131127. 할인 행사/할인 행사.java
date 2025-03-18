import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int totalDays = discount.length;
        int checkDays = 10;
        
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= totalDays - checkDays; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            for (int j = i; j < i + checkDays; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            if (isValid(wantMap, discountMap)) {
                answer++;
            }
        }
        
        return answer;
    }

    private boolean isValid(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for (String key : wantMap.keySet()) {
            if (discountMap.getOrDefault(key, 0) < wantMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}