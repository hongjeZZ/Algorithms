import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class Node {
        String word;
        int distance;

        public Node(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int[] distances = new int[words.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int distance = poll.distance;
            String word = poll.word;

            if (word.equals(target)) {
                return distance;
            }

            for (int i = 0; i < words.length; i++) {
                String next = words[i];

                int cnt = 0;
                for (int j = 0; j < next.length(); j++) {
                    if (next.charAt(j) != word.charAt(j)) {
                        cnt++;
                    }
                }
                if (cnt != 1) continue;
                
                if (distances[i] > distance + 1) {
                    distances[i] = distance + 1;
                    queue.offer(new Node(next, distance + 1));
                }
            }
        }

        return 0;
    }
}