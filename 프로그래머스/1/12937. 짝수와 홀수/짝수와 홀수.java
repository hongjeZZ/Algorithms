class Solution {
    public String solution(int num) {
        String even = "Even";
        String odd = "Odd";
        
        return num % 2 == 0 ? even : odd;
    }
}