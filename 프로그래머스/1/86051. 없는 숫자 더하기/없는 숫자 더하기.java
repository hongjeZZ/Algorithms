class Solution {
    public int solution(int[] numbers) {
        boolean[] arr = new boolean[10];

        int sum = 0;

        for (int num : numbers) {
            arr[num] = true;
        }

        for (int i = 0; i < 10; i++) {
            if (!arr[i]) {
                sum += i;
            }
        }
        return sum;
    }
}