class Solution {
    public int solution(int hp) {
        int x = hp / 5;
        hp %= 5;
        
        int y = hp / 3;
        hp %= 3;
        
        int z = hp / 1;
        hp %= 1;
        
        return x + y + z;
    }
}