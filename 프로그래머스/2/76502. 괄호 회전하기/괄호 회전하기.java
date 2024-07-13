import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = 0;
        
        for (int i = 0; i < length; i++) {
            String str = s.substring(i, length) + s.substring(0, i);
            
            if (isRightBracket(str)) {
                answer++;
            }
        }
        return answer;
    }
    
    boolean isRightBracket(String s) {
        Stack<Character> stack = new Stack<>();
        
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            }
                
            else {
                if (stack.isEmpty() || c != map.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}