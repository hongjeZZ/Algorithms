class Solution {
    public int solution(int n, int m, int[] section) {
        int loc = 0;
        int answer = 0;
        
        for (int i = 0; i < section.length; i++) {
            if (loc < section[i]) {
                answer++;
                loc = section[i] + m - 1;
            }
        }
        
        return answer;
    }
}