import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String my_string) {

        String intStr = my_string.replaceAll("[^0-9]", "");
        int[] answer = Stream.of(intStr.split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}