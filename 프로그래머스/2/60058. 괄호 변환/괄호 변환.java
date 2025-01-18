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
            String temp = "(" + solution(v) + ")";
            u = u.substring(1, u.length() - 1);
            return temp + reverse(u);
        }
    }

    // 두 균형잡힌 문자열로 반환
    public String[] split(String str) {
        String temp = "";

        for (int i = 0; i < str.length(); i = i + 2) {
            temp += str.substring(i, i + 2);

            if (checkBalance(temp)) {
                return new String[] { temp, str.substring(i + 2)};
            }
        }
        return null;
    }

    // 균형잡힌 문자열인지 확인
    public boolean checkBalance(String str) {
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
        }
        return cnt == 0;
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
        String temp = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                temp += ')';
            } else temp += '(';
        }
        
        return temp;
    }
}