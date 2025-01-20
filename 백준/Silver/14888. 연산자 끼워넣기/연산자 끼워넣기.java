import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] operators = new int[4]; // +, -, *, /
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, arr[0]);
        System.out.println(max + "\n" + min);
    }

    public static void backtracking(int depth, long currentValue) {
        if (depth == N) {
            max = Math.max(max, currentValue);
            min = Math.min(min, currentValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 연산자 사용
                long nextValue = calculate(currentValue, arr[depth], i);
                backtracking(depth + 1, nextValue); // 다음 단계로 진행
                operators[i]++; // 연산자 복원
            }
        }
    }

    public static long calculate(long a, long b, int operator) {
        switch (operator) {
            case 0: return a + b; // +
            case 1: return a - b; // -
            case 2: return a * b; // *
            case 3: return a / b; // /
            default: return 0;
        }
    }
}