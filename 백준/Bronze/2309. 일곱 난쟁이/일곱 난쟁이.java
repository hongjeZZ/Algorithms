import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] heights = new int[9];
        int sum = 0;
        
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }
        
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (heights[i] + heights[j]) == 100) {
                    int[] result = new int[7];
                    int idx = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            result[idx++] = heights[k];
                        }
                    }

                    // 결과 정렬 및 출력
                    Arrays.sort(result);
                    for (int height : result) {
                        sb.append(height).append("\n");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}