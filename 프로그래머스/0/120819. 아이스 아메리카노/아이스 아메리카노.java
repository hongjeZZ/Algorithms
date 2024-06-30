class Solution {
    public int[] solution(int money) {
        int numOfCoffee = money / 5500;
        int res = money % 5500;
        
        return new int[] { numOfCoffee, res };
    }
}