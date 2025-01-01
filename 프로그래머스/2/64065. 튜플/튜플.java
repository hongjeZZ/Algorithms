import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        String substring = s.substring(2, s.length() - 2);

        String[] split = substring.split("},\\{");
        List<Integer> list = new ArrayList<>();

        Arrays.sort(split, Comparator.comparingInt(String::length));

        for (String item : split) {
            String[] value = item.split(",");

            for (String string : value) {
                int intValue = Integer.parseInt(string);

                if (!list.contains(intValue)) {
                    list.add(intValue);
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}