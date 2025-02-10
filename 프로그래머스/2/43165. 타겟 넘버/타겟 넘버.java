import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] numbers, int target) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{numbers[0], 0});
        q.offer(new int[]{-numbers[0], 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int value = poll[0];
            int idx = poll[1];

            if (idx == numbers.length - 1) {
                if (value == target) cnt++;
                continue;
            }
            int nextIdx = idx + 1;
            q.offer(new int[]{value + numbers[nextIdx], nextIdx});
            q.offer(new int[]{value - numbers[nextIdx], nextIdx});
        }

        return cnt;
    }
}