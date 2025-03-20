class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            left.append(String.valueOf(i).repeat(count));
        }

        String center = "0";

        String right = left.reverse().toString();

        return left.reverse().toString() + center + right;
    }
}