class Solution {
    public String solution(String myString) {
        char[] charArray = myString.toCharArray();
        String answer = "";

        for (char c : charArray) {
            if (c <= 'l') answer += 'l';
            else answer += c;
        }
        return answer;
    }
}