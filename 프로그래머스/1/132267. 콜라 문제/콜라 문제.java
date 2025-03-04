class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int addCola = (n / a) * b;
            answer += addCola;
            
            n %= a;
            n += addCola;
        }
        
        return answer;
    }
}