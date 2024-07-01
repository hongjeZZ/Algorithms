import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        String[] beforeArr = before.split("");
        Arrays.sort(beforeArr);
        String[] afterArr = after.split("");
        Arrays.sort(afterArr);
        
        if (Arrays.equals(beforeArr, afterArr)) {
            return 1;
        } 
        return 0;
    }
}