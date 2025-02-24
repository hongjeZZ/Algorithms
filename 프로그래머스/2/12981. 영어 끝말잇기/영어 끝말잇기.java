import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> usedWords = new ArrayList<>();
        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String current = words[i];

            if (usedWords.contains(current) || prev.charAt(prev.length() - 1) != current.charAt(0)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            usedWords.add(current);
        }

        return new int[]{0, 0};
    }
}