public class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] validSounds = {"aya", "ye", "woo", "ma"};
        
        for (String word : babbling) {
            boolean isValid = true;
            String previousSound = "";
            
            while (!word.isEmpty()) {
                boolean matched = false;
                for (String sound : validSounds) {
                    if (word.startsWith(sound) && !sound.equals(previousSound)) {
                        word = word.substring(sound.length());
                        previousSound = sound;
                        matched = true;
                        break;
                    }
                }
                
                if (!matched) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                answer++;
            }
        }
        
        return answer;
    }
}