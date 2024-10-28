import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Integer[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Arrays.sort(arr1);  // 오름차순 정렬
        Arrays.sort(arr2, Collections.reverseOrder());  // 내림차순 정렬

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr1[i] * arr2[i];
        }

        System.out.println(sum);
    }
}