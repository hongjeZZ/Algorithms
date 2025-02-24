class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zeroCnt = 0;
        
        while (!s.equals("1")) {
            int oneCnt = s.replaceAll("0", "").length();
            zeroCnt += s.length() - oneCnt;
            s = Integer.toBinaryString(oneCnt);
            cnt++;
        }
        
        return new int[]{cnt, zeroCnt};
    }
}