class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int maxWidth = board[0] / 2;
        int maxLength = board[1] / 2;

        int width = 0;
        int length = 0;

        for (String key : keyinput) {
            switch (key) {
                case "left" -> {
                    if (width == -maxWidth) {
                        continue;
                    }
                    width--;
                }
                case "right" -> {
                    if (width == maxWidth) {
                        continue;
                    }
                    width++;
                }
                case "up" -> {
                    if (length == maxLength) {
                        continue;
                    }
                    length++;
                }
                case "down" -> {
                    if (length == -maxLength) {
                        continue;
                    }
                    length--;
                }
            }
        }
        return new int[] { width, length }; 
    }
}
