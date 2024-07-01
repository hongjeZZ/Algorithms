class Solution {
    public int solution(String my_string) {
        int sum = 0;
        int currentNumber = 0;
        boolean isNumber = false;

        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
                isNumber = true;
            } else {
                if (isNumber) {
                    sum += currentNumber;
                    currentNumber = 0;
                    isNumber = false;
                }
            }
        }
        
        if (isNumber) {
            sum += currentNumber;
        }

        return sum;
    }
}