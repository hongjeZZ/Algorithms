class Solution {

    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        return dfs(0, 0);
    }

    public int dfs(int value, int idx) {
        if (idx == numbers.length) {
            if (value == target) return 1;
            return 0;
        }

        return dfs(value + numbers[idx], idx + 1) + dfs(value - numbers[idx], idx + 1);
    }
}