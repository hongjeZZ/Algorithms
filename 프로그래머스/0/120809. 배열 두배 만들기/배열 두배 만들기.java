import java.util.ArrayList;

class Solution {
    public ArrayList solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : numbers) {
            list.add(num * 2);
        }
        return list;
    }
}