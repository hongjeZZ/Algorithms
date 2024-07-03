class Solution {
    public int solution(int a, int b) {
        String str = "";
        str += a;
        str += b;
        
        int answer1 = Integer.parseInt(str);
        int answer2 = 2 * a * b;
        
        return answer1 >= answer2 ? answer1 : answer2;
    }
}