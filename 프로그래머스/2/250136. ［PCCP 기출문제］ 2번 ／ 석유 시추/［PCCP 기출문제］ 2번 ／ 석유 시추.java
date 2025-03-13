import java.util.*;

class Solution {
    
    int n;
    int m;
    boolean[][] visited;
    int[][] land;
    int[] oil;
    int[] dx = { -1 , 1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };
    
    public int solution(int[][] land) {
        this.land = land;
        this.n = land.length;    // 세로
        this.m = land[0].length; // 가로
        this.visited = new boolean[n][m];
        this.oil = new int[m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 방문하지 않고 땅이 아니라면
                if (!visited[j][i] && land[j][i] == 1) {
                    dfs(j, i);
                }
            }
        }
        
        int max = 0;
        for (int o : oil) {
            max = Math.max(max, o);
        }
        
        return max;
    }
    
    public void dfs(int j, int i) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{j, i});
        visited[j][i] = true;
        
        int cnt = 1;
        Set<Integer> set = new HashSet<>();
        
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            set.add(y);
            
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + x;
                int ny = dy[k] + y;
                
                // 범위 검증
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                
                // 방문 검증
                if (!visited[nx][ny] && land[nx][ny] == 1) {
                    // 방문 처리
                    visited[nx][ny] = true;
                    q.add(new int[]{ nx, ny});
                    cnt++;
                }
            }
        }
        
        for (int y : set) {
            oil[y] += cnt;
        }
    }
}