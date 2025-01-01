import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            int[] arr = new int[end - start + 1];
            
            for (int j = 0; j < arr.length; j++) {
                arr[j] = array[start - 1 + j];
            }
            
            Arrays.sort(arr);

            answer[i] = arr[k -1];
        }

        return answer;
    }
}