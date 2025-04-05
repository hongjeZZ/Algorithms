import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int round = 0;

        for (; round < enemy.length; round++) {
            int curr = enemy[round];
            maxHeap.add(curr);

            n -= curr;
            if (n < 0) {
                if (k > 0) {
                    int largest = maxHeap.poll();
                    n += largest;
                    k--;
                } else {
                    break;
                }
            }
        }

        return round;
    }
}