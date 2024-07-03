class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return arr1.length > arr2.length ? 1 : -1;
        }
        
        int sum1 = 0;
        int sum2 = 0;

        for (int i : arr1) {
            sum1 += i;
        }
        for (int j : arr2) {
            sum2 += j;
        }
        
        return Integer.compare(sum1, sum2);
    }
}