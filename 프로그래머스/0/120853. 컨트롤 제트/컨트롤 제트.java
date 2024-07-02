import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.split(" ")));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("Z")) {
                list.set(i, "0");
                list.set(i - 1, "0");
            }
        }
        int answer = 0;
        for (String string : list) {
            answer += Integer.parseInt(string);
        }
        return answer;
    }
}