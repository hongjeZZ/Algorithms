class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr.clone();
        boolean isEven = arr.length % 2 == 0;

        if (!isEven) {
            for (int i = 0; i < arr.length; i += 2) {
                answer[i] += n;
            }
        }
        else {
            for (int i = 1; i < arr.length; i += 2) {
                answer[i] += n;
            }
        }
        return answer;
    }
}