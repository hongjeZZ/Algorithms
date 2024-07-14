import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        int length = progresses.length;
        int[] leftDays = new int[length];

        for (int i = 0; i < length; i++) {
            leftDays[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int count = 0;
        int maxDays = leftDays[0];

        for (int i = 0; i < length; i++) {
            if (leftDays[i] <= maxDays) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                maxDays = leftDays[i];
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}