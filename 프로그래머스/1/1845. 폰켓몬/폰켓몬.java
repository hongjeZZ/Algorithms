import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        return Math.min(N, set.size());
    }
}