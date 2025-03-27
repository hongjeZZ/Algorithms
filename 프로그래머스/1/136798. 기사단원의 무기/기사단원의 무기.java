public class Solution {
    public int solution(int number, int limit, int power) {
        int totalWeight = 0;

        for (int i = 1; i <= number; i++) {
            int attackPower = countDivisors(i);
            if (attackPower > limit) {
                attackPower = power;
            }
            totalWeight += attackPower;
        }

        return totalWeight;
    }
    
   public int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }
}