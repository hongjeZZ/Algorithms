import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        stack.push(idx);

        for (idx = 1; idx < length; idx++) {
            while(!stack.isEmpty() && prices[idx] < prices[stack.peek()]) {
                int popIdx = stack.pop();
                answer[popIdx] = idx - popIdx;
            }
            stack.push(idx);
        }

        while(!stack.isEmpty()) {
            int popIdx = stack.pop();
            answer[popIdx] = length - popIdx - 1;
        }

        return answer;
    }
}