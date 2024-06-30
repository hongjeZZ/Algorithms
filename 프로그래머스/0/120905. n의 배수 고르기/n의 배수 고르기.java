import java.util.*;

class Solution {
    public ArrayList solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : numlist) {
            if (num % n == 0) {
                list.add(num);
            }
        }
        return list;
    }
}