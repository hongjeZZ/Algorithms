class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        
        // 제곱근이 정수인지 확인
        if (sqrt == (long) sqrt) {
            long value = (long) sqrt;
            return (value + 1) * (value + 1);
        } 
        
        return -1;
    }
}