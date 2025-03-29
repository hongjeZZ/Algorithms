import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int count = 0;
        int boxNumber = 1;

        while (boxNumber <= order.length || !stack.isEmpty()) {
            if (boxNumber <= order.length && boxNumber == order[index]) {
                count++;
                index++;
                boxNumber++;
            }
            else if (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                count++;
                index++;
            }
            else if (boxNumber <= order.length) {
                stack.push(boxNumber);
                boxNumber++;
            }
            else {
                break;
            }
        }
        return count;
    }
}