import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        if (num_list.length >= 11) {
            return IntStream.of(num_list).sum();
        }
        return Arrays.stream(num_list).reduce(1, (a,b) -> a * b);
    }
}