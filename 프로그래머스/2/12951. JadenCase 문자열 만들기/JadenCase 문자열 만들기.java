class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                char firstChar = words[i].charAt(0);
                words[i] = Character.toUpperCase(firstChar) + words[i].substring(1).toLowerCase();
            }
        }

        return String.join(" ", words);
    }
}