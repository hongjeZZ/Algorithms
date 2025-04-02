import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        int[] answer = new int[n];
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i;
        }

        k--;

        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = (int) (k / fact);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k %= fact;
        }

        return answer;
    }
}