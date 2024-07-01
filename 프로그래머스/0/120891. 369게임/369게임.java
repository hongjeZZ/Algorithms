import java.util.Arrays;

class Solution {
    public int solution(int order) {
        int[] arr = Arrays.stream(String.valueOf(order).split("")).mapToInt(Integer::parseInt).toArray();
        
        int answer = 0;
        for (int num : arr) {
            if (num == 3 || num == 6 || num == 9) {
                answer++;
            }
        }
        return answer;
    }
}