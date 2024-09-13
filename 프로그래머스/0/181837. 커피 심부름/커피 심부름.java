class Solution {
    public int solution(String[] order) {
        int lattePrice = 5000;
        int amePrice = 4500;
        int answer = 0;

        for (String orderItem : order) {
            if (orderItem.contains("americano") || orderItem.equals("anything")) {
                answer += amePrice;
            }
            else if (orderItem.contains("cafelatte")) {
                answer += lattePrice;
            }
        }
        return answer;
    }
}