import java.util.*;

class Solution {
    
    static final char START = 'S';
    static final char LEVER = 'L';
    static final char END = 'E';
    static final char WAY = 'O';
    static final char BLOCK = 'X';
    
    static final int[] dx = { -1, 1, 0, 0 };
    static final int[] dy = { 0, 0, -1, 1 };
    
    int x; // 가로
    int y; // 세로
    
    public int solution(String[] maps) {
        this.y = maps.length;         // 행 수 (세로)
        this.x = maps[0].length();    // 열 수 (가로)
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        for (int i = 0; i < y; i++) {         // i: row
            for (int j = 0; j < x; j++) {     // j: column
                char c = maps[i].charAt(j);
                if (c == START) {
                    start[0] = i; start[1] = j;
                } else if (c == LEVER) {
                    lever[0] = i; lever[1] = j;
                } else if (c == END) {
                    end[0] = i; end[1] = j;
                }
            }
        }
        
        int leverCnt = bfs(maps, start, lever);
        if (leverCnt == -1) return -1;
        
        int endCnt = bfs(maps, lever, end);
        if (endCnt == -1) return -1;
        
        return leverCnt + endCnt;
    }
    
    public int bfs(String[] maps, int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[y][x]; // y행 x열
        
        q.add(new int[] { start[0], start[1], 0 });
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];
            int cnt = poll[2];
            
            if (cx == end[0] && cy == end[1]) {
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= y || ny >= x) continue;
                
                if (!visited[nx][ny] && maps[nx].charAt(ny) != BLOCK) {
                    q.add(new int[] { nx, ny, cnt + 1 });
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}