class Solution {
    
    int cnt = 0;
    int length;
    int[] arr;
    
    public int solution(int[] number) {
        arr = number;
        length = number.length;
        
        combination(0, 0, 0);
        
        return cnt;
    }
    
    private void combination(int start, int sum, int depth) {
        if (depth == 3) {
            if (sum == 0) {
                cnt++;
            }
            return;
        }
        
        for (int i = start; i < length; i++) {
            combination(i + 1, sum + arr[i], depth + 1);
        }
    }
}