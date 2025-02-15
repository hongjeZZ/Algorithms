import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int start = arr[arr.length - 1];
        
        while (true) {
            boolean flag = true;
            
            for (int value : arr) {
                if (start % value != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) break;
            else start++;
        }
        
        return start;
    }
}