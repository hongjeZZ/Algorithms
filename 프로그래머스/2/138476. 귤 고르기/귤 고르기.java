import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Collections.reverseOrder());

        int count = 0;
        for (int value : values) {
            k -= value;
            count++;
            if (k <= 0) {
                break;
            }
        }

        return count;
    }
}