class Solution {
    public int[] solution(int[] array) {
        int idx = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                idx = i;
                max = array[i];
            }
        }
        
        return new int[] { max, idx };
    }
}