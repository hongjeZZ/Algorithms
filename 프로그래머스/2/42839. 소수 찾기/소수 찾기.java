import java.util.*;

class Solution {
    
    private Set<Integer> set = new HashSet<>();
    private int cnt = 0;
    private String numbers;
    
    public int solution(String numbers) {
        this.numbers = numbers;
        combination("", new boolean[numbers.length()]);
        return cnt;
    }
    
    private void combination(String current, boolean[] used) {
        if (!current.isEmpty()) {
            int value = Integer.parseInt(current);
            if (!set.contains(value) && isSosu(value)) {
                set.add(value);
                cnt++;
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                combination(current + numbers.charAt(i), used);
                used[i] = false;
            }
        }
    }

    private boolean isSosu(int value) {
        if (value < 2) return false;
        if (value == 2) return true;
        if (value % 2 == 0) return false; 
        
        for (int i = 3; i <= Math.sqrt(value); i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}