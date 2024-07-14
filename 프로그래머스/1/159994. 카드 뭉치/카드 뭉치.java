import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> deque1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> deque2 = new ArrayDeque<>(Arrays.asList(cards2));

        for (String str : goal) {
            if (!deque1.isEmpty() && deque1.peek().equals(str)) {
                deque1.poll();
            } else if (!deque2.isEmpty() && deque2.peek().equals(str)) {
                deque2.poll();
            } else return "No";
        }
        return "Yes";
    }
}