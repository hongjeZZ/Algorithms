class Solution {
    public int solution(int n) {
        StringBuilder ternary = new StringBuilder();
        
        while (n > 0) {
            ternary.append(n % 3);
            n /= 3;
        }
        
        return Integer.parseInt(ternary.toString(), 3);
    }
}