import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int cnt = 0;
        
        Arrays.sort(d);
        
        for (int value : d) {
            budget -= value;
            cnt++;
            
            if (budget < 0) {
                cnt--;
                break;
            }
        }
        
        return cnt;
    }
}