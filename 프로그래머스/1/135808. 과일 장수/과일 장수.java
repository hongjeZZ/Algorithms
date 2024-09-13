import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        if (m > score.length) return 0;

        Integer[] arr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < score.length / m; i++) {
            answer += m * arr[(m - 1) + i * m];
        }

        return answer;
    }
}