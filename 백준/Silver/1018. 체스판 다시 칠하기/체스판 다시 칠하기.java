import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        board[i][j] = 'B';
                    } else {
                        board[i][j] = 'W';
                    }
                } else {
                    if (j % 2 == 0) {
                        board[i][j] = 'W';
                    } else {
                        board[i][j] = 'B';
                    }
                }
            }
        }

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        // 체스판 위치 변경
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (arr[k + i][l + j] == board[k][l]) {
                            cnt++;
                        }
                    }
                }
                min = Math.min(min, Math.min(cnt, 64 - cnt));
            }
        }
        System.out.println(min);
    }
}