import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int cnt = 0;

        while (left <= right) {
            if (limit >= people[left] + people[right]) {
                left++;
            }
            right--;
            cnt++;
        }
        return cnt;
    }
}