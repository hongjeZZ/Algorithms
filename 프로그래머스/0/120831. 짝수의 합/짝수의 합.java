class Solution {
    public int solution(int n) {
        int sum = 0;
        for (int i = 0; i < n + 1; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}