class Solution {
    public int solution(int num1, int num2) {
        int answer = compare(num1, num2);
        return answer;
    }
    
    int compare(int num1, int num2) {
        if (num1 == num2) {
            return 1;
        }
        return -1;
    } 
}