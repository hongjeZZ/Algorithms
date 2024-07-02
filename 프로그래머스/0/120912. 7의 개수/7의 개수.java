import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String str = "";

        for (int i = 0; i < array.length; i++) {
            str += String.valueOf(array[i]);
        }

        for (char c : str.toCharArray()) {
            if (c == '7') {
                answer++;
            }
        }
        return answer;
    }
}