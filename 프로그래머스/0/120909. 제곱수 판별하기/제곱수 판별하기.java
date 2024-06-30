import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
            }
        }

        if (set.size() % 2 == 0) return 2;
        else return 1;
    }
}