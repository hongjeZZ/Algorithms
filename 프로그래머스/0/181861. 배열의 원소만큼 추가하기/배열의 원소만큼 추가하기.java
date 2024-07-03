import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        int length = IntStream.of(arr).sum();
        int[] answer = new int[length];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}