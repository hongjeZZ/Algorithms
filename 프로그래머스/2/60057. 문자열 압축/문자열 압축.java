class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            int cnt = 1;
            String compressed = "";
            String target = s.substring(0, i);

            for (int j = i; j <= s.length(); j = j + i) {
                int end = Math.min(s.length(), i + j);
                String compare = s.substring(j, end);
                
                if (compare.equals(target)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        compressed += cnt;
                        cnt = 1;
                    }
                    compressed += target;
                    target = compare;
                }
            }
            compressed += target;
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}