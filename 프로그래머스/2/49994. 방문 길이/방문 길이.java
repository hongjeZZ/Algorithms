import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static final Map<Character, int[]> location = new HashMap<>();
    
    void initLocation() {
        location.put('U', new int[] { 0, 1 });
        location.put('D', new int[] { 0, -1 });
        location.put('R', new int[] { 1, 0 });
        location.put('L', new int[] { -1, 0 });
    }

    boolean isMovable(int x, int y) {
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }
    
    public int solution(String dirs) {
        initLocation();

        Set<String> answer = new HashSet<>();

        int x = 5;
        int y = 5;

        for (char c : dirs.toCharArray()) {
            int[] offset = location.get(c);
            int nx = x + offset[0];
            int ny = y + offset[1];

            if (!isMovable(nx, ny)) {
                continue;
            }

            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }
}