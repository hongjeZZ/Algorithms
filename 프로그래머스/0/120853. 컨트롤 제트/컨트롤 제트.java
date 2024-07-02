import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<String> stack = new Stack<>();

        for (String num : s.split(" ")) {
            if (num.equals("Z")) {
                stack.pop();
            }
            else stack.push(num);
        }

        for (String num : stack) {
            answer += Integer.parseInt(num);
        }
        return answer;
    }
}