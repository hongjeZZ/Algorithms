import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();

        Arrays.sort(lost);
        
        for (int l : lost) {
            lostSet.add(l);
        }
        
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r);
            } else {
                reserveSet.add(r);   
            }
        }

        int answer = n - lostSet.size();

        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                answer++;
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                answer++;
            }
        }
        return answer;
    }
}