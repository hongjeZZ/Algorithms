import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int sum = 0;
        String numberStr = Integer.toString(n);

        for (char c : numberStr.toCharArray()) {
            sum += Character.getNumericValue(c);
        }

        return sum;
    }
}