import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            int date = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if (!queue.isEmpty() && queue.peek() < date) {
                answer.add(queue.size());
                queue.clear();
            }
            queue.offer(date);
        }
        answer.add(queue.size());
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}