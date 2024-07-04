import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();

        for (String s : strArr) {
            if (!s.contains("ad")) list.add(s);
        }

        return list.toArray(String[]::new);
    }
}