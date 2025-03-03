class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        int pSize = p.length();
        
        for (int i = 0; i + pSize <= t.length(); i++) {
            if (t.substring(i, i + pSize).compareTo(p) <= 0) {
                cnt++;
            }
        }
        return cnt;
    }
}