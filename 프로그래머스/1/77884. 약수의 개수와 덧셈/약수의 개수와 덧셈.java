class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            if (isSquare(i)) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        
        return answer;
    }
    
    private boolean isSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}