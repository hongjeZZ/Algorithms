import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] arr3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        int[] answer = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr1[i % arr1.length]) {
                answer[0]++;
            }
            if (answers[i] == arr2[i % arr2.length]) {
                answer[1]++;
            }
            if (answers[i] == arr3[i % arr3.length]) {
                answer[2]++;
            }
        }

        int max = Arrays.stream(answer).max().getAsInt();

        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < answer.length; i++) {
            if (max == answer[i]) result.add(i + 1);
        }
        
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}