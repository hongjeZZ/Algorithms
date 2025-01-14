import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    int n;
    boolean[][] wall;
    boolean[][] floor;

    static class Block implements Comparable<Block> {
        int x;
        int y;
        int type;

        public Block(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public int compareTo(Block o) {
            if (x != o.x) {
                return x - o.x;
            } else if (y != o.y) {
                return y - o.y;
            } else {
                return type - o.type;
            }
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "," + type + "]";
        }

    }

    public boolean canBuildWall(int bx, int by) {
        return  (by == 0)                               // 바닥에 설치
                || (by - 1 >= 0 && wall[bx][by - 1])    // 아래에 기둥이 있는 경우
                || (bx - 1 >= 0 && floor[bx - 1][by])   // 왼쪽에 보가 있는 경우
                || floor[bx][by];           // 오른쪽에 보가 있는 경우
    }

    public boolean canBuildFloor(int bx, int by) {
        return  (by - 1 >= 0 && wall[bx][by - 1])          // 아래에 기둥이 있는 경우
                || (bx + 1 <= n && by - 1 >= 0 && wall[bx + 1][by - 1]) // 우측 아래에 기둥이 있는 경우
                || (bx - 1 >= 0 && bx + 1 <= n && floor[bx - 1][by] && floor[bx + 1][by]); // 좌우에 보가 있는 경우
    }

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        wall = new boolean[n + 1][n + 1];
        floor = new boolean[n + 1][n + 1];
        List<Block> blocks = new ArrayList<>();

        for (int[] frame : build_frame) {
            int bx = frame[0];
            int by = frame[1];
            int type = frame[2];
            int command = frame[3];

            // 특정 좌표에 기둥을 건설하는 경우
            if (type == 0 && command == 1) {
                // 기둥 설치 조건
                if (canBuildWall(bx, by)) {
                    blocks.add(new Block(bx, by, type));
                    wall[bx][by] = true;
                }
            }

            // 특정 좌표에 보를 건설하는 경우
            if (type == 1 && command == 1) {
                // 조건 만족 시 보 설치
                if (canBuildFloor(bx, by)) {
                    blocks.add(new Block(bx, by, type));
                    floor[bx][by] = true;
                }
            }

            // 특정 좌표에 기둥을 삭제하는 경우
            if (type == 0 && command == 0) {
                wall[bx][by] = false;

                // 좌표 위 기둥이 있는 경우
                if (by + 1 <= n && wall[bx][by + 1]) {
                    if (!canBuildWall(bx, by + 1)) {
                        wall[bx][by] = true;
                        continue;
                    }
                }
                // 기둥 위 보가 있는 경우
                if (by + 1 <= n && floor[bx][by + 1]) {
                    if (!canBuildFloor(bx, by + 1)) {
                        wall[bx][by] = true;
                        continue;
                    }
                }
                // 기둥 좌측 위 보가 있는 경우
                if (by + 1 <= n && bx - 1 >= 0 && floor[bx - 1][by + 1]) {
                    if (!canBuildFloor(bx - 1, by + 1)) {
                        wall[bx][by] = true;
                        continue;
                    }
                }
                blocks.removeIf(block -> block.x == bx && block.y == by && block.type == 0);
            }

            // 특정 좌표에 보를 삭제하는 경우
            if (type == 1 && command == 0) {
                floor[bx][by] = false;

                // 좌표에 기둥이 있는 경우
                if (wall[bx][by]) {
                    if (!canBuildWall(bx, by)) {
                        floor[bx][by] = true;
                        continue;
                    }
                }

                // 좌표 우측에 기둥이 있는 경우
                if (bx + 1 <= n && wall[bx + 1][by]) {
                    if (!canBuildWall(bx + 1, by)) {
                        floor[bx][by] = true;
                        continue;
                    }
                }

                // 좌표 우측에 보가 있는 경우
                if (bx + 1 <= n && floor[bx + 1][by]) {
                    if (!canBuildFloor(bx + 1, by)) {
                        floor[bx][by] = true;
                        continue;
                    }
                }

                // 좌표 좌측에 보가 있는 경우
                if (bx - 1 >= 0 && floor[bx - 1][by]) {
                    if (!canBuildFloor(bx - 1, by)) {
                        floor[bx][by] = true;
                        continue;
                    }
                }
                blocks.removeIf(block -> block.x == bx && block.y == by && block.type == 1);
            }
        }
        Collections.sort(blocks);

        int[][] answer = new int[blocks.size()][3];
        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            answer[i][0] = block.x;
            answer[i][1] = block.y;
            answer[i][2] = block.type;
        }
        return answer;
    }
}