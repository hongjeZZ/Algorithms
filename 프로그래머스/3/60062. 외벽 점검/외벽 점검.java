import java.util.ArrayList;
import java.util.List;

class Solution {

    int[][] weakCase;
    int[] dist;
    int d;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        this.dist = dist;
        weakCase = new int[weak.length][weak.length];
        d = dist.length;


        for (int i = 0; i < weak.length; i++) {
            for (int j = 0; j < weak.length; j++) {
                weakCase[i][j] = weak[(i + j) % weak.length] + (i + j >= weak.length ? n : 0);
            }
        }

        permutation(new ArrayList<>(), new boolean[d], 0);

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    // dist 순열 구하기
    public void permutation(List<Integer> selected, boolean[] visited, int depth) {
        // 순열이 구해지면, 각 순열마다 weakCase 를 순회하여 최소값을 구한다.
        if (depth == d) {
            int min = Integer.MAX_VALUE;

            // weakCase 순회
            for (int[] week : weakCase) {
                min = Math.min(min, getNeedMemberCount(week, selected));
            }

            answer = Math.min(min, answer);
        }

        // dist 의 길이만큼 반복하여 순열을 구한다.
        for (int i = 0; i < d; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(i); // 선택된 요소 추가
                permutation(selected, visited, depth + 1); // 재귀 호출
                selected.remove(selected.size() - 1); // 마지막 요소 제거
                visited[i] = false; // 방문 해제
            }
        }
    }

    public int getNeedMemberCount(int[] week, List<Integer> selected) {
        int count = 0;              // 필요한 멤버 수
        int startIdx = 0;           // 처리할 시작 지점

        while (startIdx < week.length) {
            if (count >= selected.size()) {
                return Integer.MAX_VALUE;
            }

            // 현재 멤버가 처리할 수 있는 최대 범위
            int distValue = dist[selected.get(count)];

            // 현재 멤버로 처리할 수 있는 범위 끝 지점
            int end = week[startIdx] + distValue;

            // 범위 내의 마지막 위치를 찾기
            while (startIdx < week.length && week[startIdx] <= end) {
                startIdx++; // 해당 멤버로 처리할 수 있는 모든 지점들 처리
            }

            count++; // 멤버 하나 추가

            if (startIdx >= week.length) {
                break; // 모든 지점을 처리한 경우
            }
        }
        return count;
    }
}