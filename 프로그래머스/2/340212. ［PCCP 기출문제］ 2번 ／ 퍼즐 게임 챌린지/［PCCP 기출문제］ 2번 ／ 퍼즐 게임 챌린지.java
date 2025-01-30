class Solution {
    
    int[] diffs;
    int[] times;
    long limit;
    int length;

    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        this.length = diffs.length;

        int low = 1, high = getMax(diffs);
        int answer = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (solvePuzzle(mid)) {
                answer = mid; // 가능한 최소 level 업데이트
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    public boolean solvePuzzle(int level) {
        long time = 0;

        for (int i = 0; i < length; i++) {
            if (diffs[i] <= level) {
                time += times[i];
            } else {
                long count = diffs[i] - level;
                time += times[i] + count * (times[i] + times[i - 1]);
            }

            if (time > limit) {
                return false;
            }
        }

        return true;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}