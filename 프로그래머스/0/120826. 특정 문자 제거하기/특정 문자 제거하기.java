class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        for (String str : my_string.split("")) {
            if (!str.equals(letter)) answer += str;
        }
        
        return answer;
    }
}