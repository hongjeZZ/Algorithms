class Solution {
    public String solution(String my_string) {
        String[] arr = my_string.split("");
        String answer = "";
        
        for (int i = 1; i < arr.length + 1; i++) {
            answer += arr[arr.length - i];
        }
        return answer;
    }
}