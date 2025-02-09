class Solution {
    public int[] solution(int brown, int yellow) {
        // 가로의 길이는 세로의 길이보다 같거나 길다.
        int sum = brown + yellow;

        for (int i = 2; i < sum / 2; i++) {
            if (sum % i != 0) {
                continue;
            }

            int weight = Math.max(sum / i, i);
            int height = Math.min(sum / i, i);

            if (weight * 2 + height * 2 - 4 == brown) {
                return new int[]{weight, height};
            }
        }
        return null;
    }
}