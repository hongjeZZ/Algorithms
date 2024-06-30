class Solution {
    public int[] solution(int[] numbers, String direction) {
        int length = numbers.length;
        int[] result = new int[length];

        if (direction.equals("right")) {
            for (int i = 0; i < length; i++) {
                result[(i + 1) % length] = numbers[i];
            }
        } else if (direction.equals("left")) {
            for (int i = 0; i < length; i++) {
                result[i] = numbers[(i + 1) % length];
            }
        }

        return result;
    }
}