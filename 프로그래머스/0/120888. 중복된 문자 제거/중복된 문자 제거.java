import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public String solution(String my_string) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(my_string.split("")));
        return String.join("", set);
    }
}