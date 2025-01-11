class Solution {
    public int solution(String s) {
        // 최대 문자열의 길이
        int answer = s.length();
        int cnt = 1;

        // 1 ~ (문자열의 길이 / 2) 까지 모든 경우 비교
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            StringBuilder sb = new StringBuilder();
            String target = s.substring(0, i);

            for (int j = i; j < s.length() + 1; j += i) {
                int end = Math.min(s.length(), j + i);
                String compare = s.substring(j, end);

                if (target.equals(compare)) {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        sb.append(cnt);
                    }
                    sb.append(target);
                    target = compare;
                    cnt = 1;
                }
            }
            // 남은 문자열 추가
            sb.append(target);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}