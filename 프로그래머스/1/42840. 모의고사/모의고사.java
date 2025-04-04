import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        int[] oneAnswer = { 1, 2, 3, 4, 5 };
        int[] twoAnswer = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] threeAnswer = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        for (int i = 0; i < answers.length; i++) {
            int num = answers[i];
            
            if (num == oneAnswer[i % oneAnswer.length]) {
                answer[0]++;
            }
            
            if (num == twoAnswer[i % twoAnswer.length]) {
                answer[1]++;
            }
            
            if (num == threeAnswer[i % threeAnswer.length]) {
                answer[2]++;
            }
        }
        
        int max = Math.max(Math.max(answer[0], answer[1]), answer[2]);
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (answer[i] == max) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}