import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int toRemove = k;

        for (char digit : number.toCharArray()) {
            while (!stack.isEmpty() && toRemove > 0 && stack.peek() < digit) {
                stack.pop();
                toRemove--;
            }
            stack.push(digit);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length() - k; i++) {
            result.append(stack.get(i));
        }

        return result.toString();
    }
}