class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String kStr = String.valueOf(k);

        for (int l = i; l <= j; l++) {
            String s = String.valueOf(l);
            for (int m = 0; m < s.length(); m++) {
                if (s.charAt(m) == kStr.charAt(0)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}