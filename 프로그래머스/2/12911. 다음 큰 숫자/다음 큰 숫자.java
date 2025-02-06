class Solution {
    public int solution(int n) {
        int cnt = getOneCount(n);
        int answer = n + 1;
        
        while (true) {
            if (cnt == getOneCount(answer)) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    public int getOneCount(int n) {
        int count = 0;
        
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') count++;
        }
        
        return count;
    }
}