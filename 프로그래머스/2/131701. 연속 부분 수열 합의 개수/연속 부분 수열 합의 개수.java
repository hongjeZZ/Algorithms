import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;
        int[] prefixSum = new int[n * 2 + 1];

        for (int i = 1; i <= n * 2; i++) {
            prefixSum[i] = prefixSum[i - 1] + elements[(i - 1) % n];
        }

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = prefixSum[start + len] - prefixSum[start];
                set.add(sum);
            }
        }
        return set.size();
    }
}