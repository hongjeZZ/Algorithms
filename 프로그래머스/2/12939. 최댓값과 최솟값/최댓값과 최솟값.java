class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String string : split) {
            int num = Integer.parseInt(string);

            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        String answer = min + " " + max;
        return answer;
    }
}