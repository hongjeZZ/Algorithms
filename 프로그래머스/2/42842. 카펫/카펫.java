class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        for (int i = 3; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                int width = sum / i;
                if (width * 2 + i * 2 - 4 == brown) {
                    return new int[]{width, i};
                }
            }
        }
        return null;
    }
}