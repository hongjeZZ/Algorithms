import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String myString) {
        String[] arr = myString.split("x", -1);

        List<Integer> list = new ArrayList<>();

        for (String s : arr) {
            list.add(s.length());
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}