import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int value : scoville) {
            pq.add(value);
        }
        
        int cnt = 0;
        
        while (pq.peek() < K && pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b * 2);
            cnt++;
        }
        
        return pq.peek() < K ? -1 : cnt;
    }
}