import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] users = new int[N + 2];

        for (int stage : stages) {
            users[stage]++;
        }

        Map<Integer, Double> map = new HashMap<>();
        double numOfUser = stages.length;

        for (int i = 1; i <= N; i++) {
            if (users[i] == 0) {
                map.put(i, 0.);
            }
            else {
                map.put(i, users[i] / numOfUser);
                numOfUser -= users[i];
            }
        }
        
        return map.entrySet().stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}