import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (i % 2 != 0) {
                result.add(i);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}