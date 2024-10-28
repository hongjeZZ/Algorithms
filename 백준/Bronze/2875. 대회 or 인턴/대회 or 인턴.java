import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int M = arr[1];
        int K = arr[2];

        int team = 0;

        while (N >= 2 && M >= 1 && (N + M) - K >= 3) {
            team++;
            N -= 2;
            M -= 1;
        }

        System.out.println(team);
    }
}