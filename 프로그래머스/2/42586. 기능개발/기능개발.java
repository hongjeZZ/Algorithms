import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> progressDeque = new ArrayDeque<>();
        ArrayDeque<Integer> speedDeque = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            progressDeque.addLast(progresses[i]);
            speedDeque.addLast(speeds[i]);
        }

        while(!progressDeque.isEmpty()) {
            for (int i = 0; i < progressDeque.size(); i++) {
                int progress = progressDeque.pollFirst();
                int speed = speedDeque.pollFirst();

                progressDeque.addLast(progress + speed);
                speedDeque.addLast(speed);
            }

            int count = 0;
            while(!progressDeque.isEmpty() && progressDeque.getFirst() >= 100) {
                progressDeque.pollFirst();
                speedDeque.pollFirst();
                count++;
            }
            
            if (count != 0) {
                list.add(count);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}