class Solution {
    public int[] solution(int start_num, int end_num) {
        int N = end_num - start_num;
        int[] answer = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            answer[i] = i + start_num;
        }
        
        return answer;
    }
}