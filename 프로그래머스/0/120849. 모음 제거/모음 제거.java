class Solution {
    public String solution(String my_string) {
        String vowels = "aeiou";
        String answer = "";

        for (char c : my_string.toCharArray()) {
            if (vowels.indexOf(c) == -1) {
                answer += c;
            }
        }
        return answer;
    }
}