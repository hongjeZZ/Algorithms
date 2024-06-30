class Solution {
    public String solution(String my_string) {
        StringBuilder result = new StringBuilder();
        for (char c : my_string.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            }
            else  {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }
}