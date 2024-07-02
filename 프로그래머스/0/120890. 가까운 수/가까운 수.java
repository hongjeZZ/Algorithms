class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int minDiff = Integer.MAX_VALUE;
            
        for (int num : array) {
            int diff = Math.abs(num - n);
            
            if (diff < minDiff) {
                minDiff = diff;
                answer = num;
            } else if (diff == minDiff && num < answer) {
                answer = num;
            }
        } 
        
        return answer;
    }
}