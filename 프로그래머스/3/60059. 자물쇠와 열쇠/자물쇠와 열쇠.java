class Solution {

    int M;
    int N;
    int length;

    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        length = N + (M - 1) * 2;

        int[][] arr = new int[length][length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i + M - 1][j + M - 1] = lock[i][j];
            }
        }

        if (check(arr)) {
            return true;
        }

        // Key 4방향 탐색
        for (int i = 0; i < 4; i++) {
            // 모든 경우의 수 확인
            for (int j = 0; j <= length - M; j++) {
                for (int k = 0; k <= length - M; k++) {
                    // key 의 요소 더하기
                    for (int l = 0; l < M; l++) {
                        for (int m = 0; m < M; m++) {
                            arr[l + j][m + k] += key[l][m];
                        }
                    }
                    // key 를 더한 후, 해당 칸의 0이 남아있는지 확인
                    if (check(arr)) {
                        return true;
                    }
                    // 다시 key 를 빼기
                    for (int l = 0; l < M; l++) {
                        for (int m = 0; m < M; m++) {
                            arr[l + j][m + k] -= key[l][m];
                        }
                    }
                }
            }
            // 시계 방향 90도 회전
            key = rotate(key);
        }

        return false;
    }

    int[][] rotate(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n - 1 - j][i];
            }
        }
        return rotate;
    }

    boolean check(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i + M - 1][j + M - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}