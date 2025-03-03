class Solution {
    public int[] solution(int n, int m) {
        return new int[] { getGCD(n, m), getLCM(n, m)};
    }
    
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }
}