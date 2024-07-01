class Solution {
    public int solution(int n) {
        int answer = 0;
        int max = 0;
        
        for (int i = 0; max <= n; i++) {
            max = factorial(i);
            answer = i;
        }
        
        return answer - 1;
    }
    
    int factorial(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        return n * factorial(n - 1);
    }
}