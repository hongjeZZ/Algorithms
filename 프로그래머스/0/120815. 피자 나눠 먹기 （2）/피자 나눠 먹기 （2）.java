class Solution {
    public int solution(int n) {
        int max = 0;
        
        for (int i = 1; i <= n && i <= 6; i++) {
            if (n % i == 0 && 6 % i == 0) {
                max = i;
            }
        }
        
        return (6 * n) / (max * 6);
    }
}