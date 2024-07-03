class Solution {
    public int solution(int[] num_list) {
        String evenSum = "";
        String oddSum = "";

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                evenSum += num_list[i];
            } else {
                oddSum += num_list[i];
            }
        }

        return Integer.parseInt(evenSum) + Integer.parseInt(oddSum);
    }
}