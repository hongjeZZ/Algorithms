import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }

        String[] split = split(p);
        String u = split[0];
        String v = split[1];

        if (checkRight(u)) {
            return u + solution(v);
        } else {
            return  "(" + solution(v) + ")" + reverse(u.substring(1, u.length() - 1));
        }
    }

    // 두 균형잡힌 문자열로 반환
    public String[] split(String str) {
        int balance = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                return new String[] { str.substring(0, i + 1), str.substring(i + 1) };
            }
        }
        return new String[] { str, "" };
    }

    // 올바른 괄호 문자열인지 확인
    public boolean checkRight(String u) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < u.length(); i++) {
            char current = u.charAt(i);

            if (current == '(') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public String reverse(String str) {
        StringBuilder reversed = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                reversed.append(')');
            } else {
                reversed.append('(');
            }
        }
        return reversed.toString();
    }
}