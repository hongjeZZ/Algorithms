import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static List<Integer> list;

    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        // +(0), -(1), x(2), /(3)
        for (int i = 0; i < 4; i++) {
            int value = Integer.parseInt(st.nextToken());
            for (int j = 0; j < value; j++) {
                list.add(i);
            }
        }

        permutation(new ArrayList<>(), new boolean[N - 1], 0);
        System.out.println(max + "\n" + min);
    }

    public static void permutation(List<Integer> selected, boolean[] visited, int depth) {
        if (depth == N - 1) {
            max = Math.max(max, calculate(selected));
            min = Math.min(min, calculate(selected));
            return;
        }

        // 연산자의 수만큼 반복
        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(list.get(i));                            // 선택된 요소 추가
                permutation(selected, visited, depth + 1);  // 재귀 호출
                selected.remove(selected.size() - 1);       // 마지막 요소 제거
                visited[i] = false;                         // 방문 해제
            }
        }
    }

    public static long calculate(List<Integer> selected) {
        long res = arr[0];

        for (int i = 0; i < selected.size(); i++) {
            Integer value = selected.get(i);

            if (value == 0) {
                res += arr[i + 1];
            } else if (value == 1) {
                res -= arr[i + 1];
            } else if (value == 2) {
                res *= arr[i + 1];
            } else {
                res /= arr[i + 1];
            }
        }
        return res;
    }
}