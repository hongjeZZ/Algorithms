class Solution {

    int count;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        count = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                count++;
            }
        }

        return count;
    }

    public void dfs(int idx, int[][] computers) {
        // 방문 처리
        visited[idx] = true;

        for (int i = 0; i < computers[idx].length; i++) {
            if (i == idx) {
                continue;
            }
            if (!visited[i] && computers[idx][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}