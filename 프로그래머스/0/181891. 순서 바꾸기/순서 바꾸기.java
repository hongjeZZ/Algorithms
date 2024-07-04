import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] arr1 = Arrays.copyOfRange(num_list, n, num_list.length);
        int[] arr2 = Arrays.copyOfRange(num_list, 0, n);

        int[] answer = new int[num_list.length];

        System.arraycopy(arr1, 0, answer, 0, arr1.length);
        System.arraycopy(arr2, 0, answer, arr1.length, arr2.length);
        
        return answer;
    }
}