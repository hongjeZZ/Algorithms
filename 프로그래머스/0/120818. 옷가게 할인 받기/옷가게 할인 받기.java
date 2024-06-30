class Solution {
    public int solution(int price) {
        double p = 0.0;
        
        if (price < 100000) p = 0.0;
        else if (price < 300000) p = 0.05;
        else if (price < 500000) p = 0.1;
        else p = 0.2;
        
        return (int) (price * (1 - p));
    }
}