import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 점수 저장
        Map<Character, Integer> map = new HashMap<>();
        for (char c : "RTCFJMAN".toCharArray()) {
            map.put(c, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);

            int score = Math.abs(choices[i] - 4);

            if (choices[i] < 4) {
                map.put(disagree, map.get(disagree) + score);
            } else if (choices[i] > 4) {
                map.put(agree, map.get(agree) + score);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(map.get('R') >= map.get('T') ? "R" : "T");
        result.append(map.get('C') >= map.get('F') ? "C" : "F");
        result.append(map.get('J') >= map.get('M') ? "J" : "M");
        result.append(map.get('A') >= map.get('N') ? "A" : "N");

        return result.toString();
    }
}